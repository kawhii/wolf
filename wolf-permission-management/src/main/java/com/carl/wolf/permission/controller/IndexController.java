/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.permission.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public Object index() {
        return "index page";
    }

    @GetMapping("/user/{id}")
    public Object user(@PathVariable(value = "id") String id) {
        return "users page:" + id;
    }
}
