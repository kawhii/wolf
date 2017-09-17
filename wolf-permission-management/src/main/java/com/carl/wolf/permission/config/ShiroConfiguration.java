/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.permission.config;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import io.buji.pac4j.filter.CallbackFilter;
import io.buji.pac4j.filter.LogoutFilter;
import io.buji.pac4j.filter.SecurityFilter;
import io.buji.pac4j.realm.Pac4jRealm;
import io.buji.pac4j.subject.Pac4jSubjectFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.AbstractShiroWebFilterConfiguration;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.pac4j.cas.client.CasClient;
import org.pac4j.cas.client.rest.CasRestFormClient;
import org.pac4j.cas.config.CasConfiguration;
import org.pac4j.cas.config.CasProtocol;
import org.pac4j.core.client.Clients;
import org.pac4j.core.config.Config;
import org.pac4j.http.client.direct.ParameterClient;
import org.pac4j.jwt.config.encryption.ECEncryptionConfiguration;
import org.pac4j.jwt.config.encryption.SecretEncryptionConfiguration;
import org.pac4j.jwt.config.signature.RSASignatureConfiguration;
import org.pac4j.jwt.config.signature.SecretSignatureConfiguration;
import org.pac4j.jwt.credentials.authenticator.JwtAuthenticator;
import org.pac4j.jwt.profile.JwtGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;
import java.util.Map;

/**
 * 对shiro的安全配置，是对cas的登录策略进行配置
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@Configuration
public class ShiroConfiguration extends AbstractShiroWebFilterConfiguration {
    @Value("#{ @environment['cas.prefixUrl'] ?: null }")
    private String prefixUrl;
    @Value("#{ @environment['cas.loginUrl'] ?: null }")
    private String casLoginUrl;
    @Value("#{ @environment['cas.callbackUrl'] ?: null }")
    private String callbackUrl;

    @Value("${jwt.salt}")
    private String salt;

    @Bean
    public Realm pac4jRealm() {
        return new Pac4jRealm();
    }

    /**
     * cas核心过滤器
     * @return
     */
    @Bean
    public Filter casSecurityFilter() {
        SecurityFilter filter = new SecurityFilter();
        filter.setClients("CasClient,form,jwt");
        filter.setConfig(casConfig());
        return filter;
    }

    @Bean
    protected JwtGenerator jwtGenerator(JwtAuthenticator jwtAuthenticator) {
        JwtGenerator jwtGenerator = new JwtGenerator();
        jwtAuthenticator.setEncryptionConfigurations(jwtAuthenticator.getEncryptionConfigurations());
        jwtAuthenticator.setSignatureConfigurations(jwtAuthenticator.getSignatureConfigurations());
        return jwtGenerator;
//        return new JwtGenerator(new SecretSignatureConfiguration(salt), new SecretEncryptionConfiguration(salt));
    }




    @Bean
    protected Clients clients() {
        Clients clients = new Clients();
        CasRestFormClient casRestFormClient = new CasRestFormClient();
        casRestFormClient.setConfiguration(casConfiguration());
        casRestFormClient.setName("form");
        ParameterClient parameterClient = new ParameterClient("token", jwtAuthenticator());
        parameterClient.setSupportGetRequest(true);
        parameterClient.setName("jwt");
        clients.setClients(casClient(), casRestFormClient, parameterClient);
        return clients;
    }

    @Bean
    protected JwtAuthenticator jwtAuthenticator() {
        JwtAuthenticator jwtAuthenticator = new JwtAuthenticator();
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            KeyPair rsaKeyPair = keyGen.generateKeyPair();
            jwtAuthenticator.addSignatureConfiguration(new SecretSignatureConfiguration(salt));
//            jwtAuthenticator.addSignatureConfiguration(new RSASignatureConfiguration(rsaKeyPair));

            keyGen = KeyPairGenerator.getInstance("EC");
            KeyPair ecKeyPair = keyGen.generateKeyPair();
            ECEncryptionConfiguration encConfig = new ECEncryptionConfiguration(ecKeyPair);
            encConfig.setAlgorithm(JWEAlgorithm.ECDH_ES_A128KW);
            encConfig.setMethod(EncryptionMethod.A192CBC_HS384);
            jwtAuthenticator.addEncryptionConfiguration(new SecretEncryptionConfiguration(salt));
//            jwtAuthenticator.addEncryptionConfiguration(encConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jwtAuthenticator;
    }

    @Bean
    protected Config casConfig() {
        Config config = new Config();
        config.setClients(clients());
        return config;
    }

    @Bean
    public CasConfiguration casConfiguration() {
        CasConfiguration casConfiguration = new CasConfiguration(casLoginUrl);
        casConfiguration.setProtocol(CasProtocol.CAS30);
        casConfiguration.setPrefixUrl(prefixUrl);
        return casConfiguration;
    }

    @Bean
    public CasClient casClient() {
        CasClient casClient = new CasClient();
        casClient.setConfiguration(casConfiguration());
        casClient.setCallbackUrl(callbackUrl);
        return casClient;
    }


    /**
     * 路径过滤设置
     * @return
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
       definition.addPathDefinition( "/user/**","casSecurityFilter");
        definition.addPathDefinition( "/callback", "callbackFilter");
        definition.addPathDefinition( "/logout", "logoutFilter");
        definition.addPathDefinition("/**", "anon");
        return definition;
    }


    /**
     * 由于cas代理了用户，所以必须通过cas进行创建对象
     * @return
     */
    @Bean
    protected SubjectFactory subjectFactory() {
        return new Pac4jSubjectFactory();
    }

    /**
     * 对过滤器进行调整
     * @param securityManager
     * @return
     */
    @Bean
    protected ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
         //把subject对象设为subjectFactory
        ((DefaultSecurityManager)securityManager).setSubjectFactory(subjectFactory());
        ShiroFilterFactoryBean filterFactoryBean = super.shiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);

        filterFactoryBean.setFilters(filters());
        return filterFactoryBean;
    }

    @Bean
    protected  Map<String, Filter> filters() {
        //过滤器设置
        Map<String, Filter> filters = new HashMap<>();
        filters.put("casSecurityFilter", casSecurityFilter());
        CallbackFilter callbackFilter = new CallbackFilter();
        callbackFilter.setConfig(casConfig());
        filters.put("callbackFilter", callbackFilter);
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setConfig(casConfig());
        filters.put("logoutFilter", logoutFilter);
        return filters;
    }
}
