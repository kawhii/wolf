/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.listener;

import com.carl.wolf.core.config.ProcessorConfiguration;
import com.carl.wolf.core.controller.SystemModuleTestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SystemModuleTestController.class})
@Import(ProcessorConfiguration.class)
public class ModuleScanProcessorTest {
    @Test
    public void onApplicationEvent() throws Exception {
    }

}