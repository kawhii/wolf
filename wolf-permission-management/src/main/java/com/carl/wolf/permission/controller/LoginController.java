/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.permission.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carl
 * @date 2017/9/16
 * @since
 */
@Controller
public class LoginController {
    @RequestMapping("/login.html")
    public String login() {
        return "/login";
    }
}
