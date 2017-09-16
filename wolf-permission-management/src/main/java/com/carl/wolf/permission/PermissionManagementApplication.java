/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@SpringBootApplication
@EnableWebMvc
public class PermissionManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(PermissionManagementApplication.class, args);
    }
}
