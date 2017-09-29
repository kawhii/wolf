/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.annotation.Module;
import com.carl.wolf.core.exception.ModuleScanException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 默认模块扫描策略
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class DefaultModuleScanStrategy implements IModuleScanStrategy {
    private static final Log logger = LogFactory.getLog(DefaultModuleScanStrategy.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public com.carl.wolf.core.bean.Module process(Object bean) throws ModuleScanException {
        logger.debug("扫描对象 " + bean.getClass().getName());
        Module module = bean.getClass().getAnnotation(Module.class);
        if (module == null) {
            throw new ModuleScanException(bean.getClass().getName() + "需要com.carl.wolf.core.annotation.Module注解");
        }
        com.carl.wolf.core.bean.Module moduleVo = new com.carl.wolf.core.bean.Module();
        moduleVo.setDescription(module.description())
                .setName(module.name())
                .setOrder(module.order())
                .setOpen(module.open())
                .setTarget(bean);
        try {
            logger.info(mapper.writeValueAsString(moduleVo));
        } catch (JsonProcessingException e) {
        }
        return moduleVo;
    }
}
