/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */


package com.carl.wolf.core.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Map;

/**
 * 模块数据对象
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class Module {
    private String id;
    private String name;
    private String description;
    private int order;
    private boolean open;
    //注解模块对象
    @JsonIgnore
    private Object target;

    private String icon;

    private Map<String, Object> pros;

    //所有菜单
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public Module setMenus(List<Menu> menus) {
        this.menus = menus;
        return this;
    }

    public String getId() {
        return id;
    }

    public Module setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Module setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Module setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public Module setOrder(int order) {
        this.order = order;
        return this;
    }

    public boolean isOpen() {
        return open;
    }

    public Module setOpen(boolean open) {
        this.open = open;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public Module setTarget(Object target) {
        this.target = target;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Module setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Map<String, Object> getPros() {
        return pros;
    }

    public Module setPros(Map<String, Object> pros) {
        this.pros = pros;
        return this;
    }
}
