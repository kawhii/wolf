/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.bean.Menu;
import com.carl.wolf.core.exception.ScanException;

import java.lang.reflect.Method;

/**
 * 默认的菜单扫描路径，通过method进行反射扫描
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class DefaultMenuScanStrategy implements IMenuScanStrategy {
    @Override
    public Menu process(Object target) throws ScanException {
        Method method = (Method) target;
        com.carl.wolf.core.annotation.Menu menu = method.getDeclaredAnnotation(com.carl.wolf.core.annotation.Menu.class);
        Menu menuVo = new Menu();
        menuVo.setIcon(menu.icon())
                .setOrder(menu.order())
                .setPath(menu.path())
                .setTitle(menu.title())
                .setTarget(target);
        return menuVo;
    }

    @Override
    public boolean support(Object target) {
        return target instanceof Method;
    }
}
