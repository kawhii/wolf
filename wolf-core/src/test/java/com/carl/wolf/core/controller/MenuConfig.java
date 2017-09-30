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
public class MenuConfig implements Serializable {
    private String[] persons = {"zhangsan", "wangwu"};

    public String[] getPersons() {
        return persons;
    }

    public MenuConfig setPersons(String[] persons) {
        this.persons = persons;
        return this;
    }
}
