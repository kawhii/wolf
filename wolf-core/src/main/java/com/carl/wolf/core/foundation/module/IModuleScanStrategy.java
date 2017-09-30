/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.bean.Module;


/**
 * 模块扫描策略，为了自动化初始菜单
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public interface IModuleScanStrategy extends IScanStrategy<Module> {

    /**
     * 菜单扫描策略
     *
     * @return
     */
    IMenuScanStrategy getMenuScanStrategy();
}
