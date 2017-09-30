/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.annotation;

import java.io.Serializable;
import java.lang.annotation.*;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Menu {
    /**
     * 菜单图标路径
     *
     * @return
     */
    String icon() default "";

    /**
     * 菜单名称
     *
     * @return
     */
    String title() default "";

    /**
     * 路径
     *
     * @return
     */
    String path();

    /**
     * 排序
     *
     * @return
     */
    int order() default 0;

    /**
     * 其他属性
     *
     * @return
     */
    Class<? extends Serializable>[] pros() default {};
}
