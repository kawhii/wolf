/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.bean.Module;
import com.carl.wolf.core.exception.ModuleScanException;


/**
 * 模块扫描策略，为了自动化初始菜单
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public interface IModuleScanStrategy extends IScanStrategy<Module> {
    /**
     * 在对象中抽离出模块对象
     *
     * @param bean 被注解的对象
     * @return
     */
    Module process(Object bean) throws ModuleScanException;

    /**
     * 菜单扫描策略
     *
     * @return
     */
    IMenuScanStrategy getMenuScanStrategy();
}
