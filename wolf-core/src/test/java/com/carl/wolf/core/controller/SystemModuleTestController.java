/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.controller;

import com.carl.wolf.core.annotation.Menu;
import com.carl.wolf.core.annotation.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@Controller
@Module(name = "系统管理", order = 1, description = "核心功能", pros = ModuleConfig.class)
public class SystemModuleTestController {

    @RequestMapping("sys/userMgt.html")
    @Menu(path = "sys/userMgt.html", title = "用户管理", icon = "userMgt.jpg")
    public String userManagement() {
        return "system/userManagement";
    }

    @RequestMapping("sys/roleMgt.html")
    @Menu(path = "sys/routeMgt.html", title = "角色管理", icon = "roleMgt.jpg" , pros = MenuConfig.class)
    public String roleManagement() {
        return "system/roleManagement";
    }
}
