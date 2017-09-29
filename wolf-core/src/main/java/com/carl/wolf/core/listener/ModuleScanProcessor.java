/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.listener;

import com.carl.wolf.core.annotation.Module;
import com.carl.wolf.core.exception.ModuleScanException;
import com.carl.wolf.core.foundation.module.IModuleScanStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 模块扫描器，在容器启动完时获取对应的注解解析，进行持久化
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class ModuleScanProcessor implements ApplicationListener<ContextRefreshedEvent> {
    private static final Log logger = LogFactory.getLog(ModuleScanProcessor.class);

    //模块扫描策略
    @Autowired
    private IModuleScanStrategy scanStrategy;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //模块执行完会执行该方法
        logger.debug("开始扫描模块");
        //获取所有有模块注解的对象
        Map<String, Object> beans = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(Module.class);
        List<com.carl.wolf.core.bean.Module> modules = new ArrayList<>();
        for (Object value : beans.values()) {
            try {
                //处理获取模块并且添加到容器
                if (scanStrategy.support(value)) {
                    modules.add(scanStrategy.process(value));
                }
            } catch (ModuleScanException e) {
                logger.error("模块扫描异常", e);
            }
        }
    }
}
