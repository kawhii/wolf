/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.controller;

import java.io.Serializable;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class ModuleConfig implements Serializable {
    private String name="carl";
    private int age = 1;

    public String getName() {
        return name;
    }

    public ModuleConfig setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public ModuleConfig setAge(int age) {
        this.age = age;
        return this;
    }
}
