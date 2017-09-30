/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.bean.Module;
import com.carl.wolf.core.controller.SystemModuleTestController;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class DefaultModuleScanStrategyTest {
    private SystemModuleTestController controller = new SystemModuleTestController();
    @Test
    public void process() throws Exception {
        DefaultModuleScanStrategy scanStrategy = new DefaultModuleScanStrategy();
        Module module = scanStrategy.process(controller);
        Assert.assertEquals(2, module.getMenus().size());
        Assert.assertEquals(1, module.getPros().get("age"));
        Assert.assertEquals("系统管理", module.getName());
    }

}