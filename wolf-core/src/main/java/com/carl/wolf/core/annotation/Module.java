/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.annotation;

import java.io.Serializable;
import java.lang.annotation.*;

/**
 * 标明是模块路径
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Module {
    /**
     * 模块名称，支持表达式
     *
     * @return
     */
    String name() default "";

    /**
     * 排序
     *
     * @return
     */
    int order() default 0;

    /**
     * 描述
     *
     * @return
     */
    String description() default "";

    /**
     * 是否默认展开
     *
     * @return
     */
    boolean open() default false;

    /**
     * 图标
     *
     * @return
     */
    String icon() default "";

    /**
     * 其他属性
     *
     * @return
     */
    Class<? extends Serializable>[] pros() default {};
}
