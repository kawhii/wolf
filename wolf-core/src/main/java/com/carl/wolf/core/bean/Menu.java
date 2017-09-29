/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Method;

/**
 * 菜单数据
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class Menu {
    private String id;
    private String title;
    private String path;
    private String icon;
    private int order;
    //注解菜单对象
    @JsonIgnore
    private Object target;

    public String getId() {
        return id;
    }

    public Menu setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Menu setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Menu setPath(String path) {
        this.path = path;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Menu setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public Menu setOrder(int order) {
        this.order = order;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Object setTarget(Object target) {
        this.target = target;
        return this;
    }
}
