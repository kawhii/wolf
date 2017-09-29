/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 模块扫描器，
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class ModuleScanProcessor implements ApplicationListener<ContextRefreshedEvent> {
    private static final Log logger = LogFactory.getLog(ModuleScanProcessor.class);
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //模块执行完会执行该方法
        //TODO 扫描注解解析成bean进行持久化
        logger.debug("项目初始化完成");
    }
}
