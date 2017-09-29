/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
