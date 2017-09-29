/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.JSONUtil;
import com.carl.wolf.core.annotation.Menu;
import com.carl.wolf.core.annotation.Module;
import com.carl.wolf.core.exception.ModuleScanException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认模块扫描策略
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class DefaultModuleScanStrategy implements IModuleScanStrategy {
    private static final Log logger = LogFactory.getLog(DefaultModuleScanStrategy.class);

    //菜单扫描路径
    private IMenuScanStrategy menuScanStrategy = new DefaultMenuScanStrategy();

    @Override
    public com.carl.wolf.core.bean.Module process(Object bean) throws ModuleScanException {
        logger.debug("扫描对象 " + bean.getClass().getName());
        Module module = bean.getClass().getAnnotation(Module.class);
        if (module == null) {
            throw new ModuleScanException(bean.getClass().getName() + "需要com.carl.wolf.core.annotation.Module注解");
        }
        com.carl.wolf.core.bean.Module moduleVo = new com.carl.wolf.core.bean.Module();


        //获取所有类的方法
        Method[] methods = bean.getClass().getMethods();
        List<com.carl.wolf.core.bean.Menu> menus = new ArrayList<>();

        for (Method method : methods) {
            Menu menu = method.getDeclaredAnnotation(Menu.class);
            //获取有注解的并且处理
            if (menu != null) {
                if (getMenuScanStrategy().support(method)) {
                    menus.add(getMenuScanStrategy().process(method));
                }
            }
        }

        moduleVo.setDescription(module.description())
                .setName(module.name())
                .setOrder(module.order())
                .setOpen(module.open())
                .setTarget(bean)
                .setMenus(menus);

        logger.info(JSONUtil.toJSonStr(moduleVo));
        return moduleVo;
    }

    @Override
    public IMenuScanStrategy getMenuScanStrategy() {
        return menuScanStrategy;
    }

    @Override
    public boolean support(Object target) {
        return true;
    }
}
