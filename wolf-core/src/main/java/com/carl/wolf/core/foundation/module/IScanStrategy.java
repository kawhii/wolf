/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.foundation.module;

import com.carl.wolf.core.bean.Menu;
import com.carl.wolf.core.exception.ScanException;

import java.lang.reflect.Method;

/**
 * 菜单扫描
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public interface IScanStrategy<T> {
    /**
     * 根据方法进行
     *
     * @param target 扫描对象
     * @return
     */
    T process(Object target) throws ScanException;

    /**
     * 是否支持该对象的扫描
     * @param target
     * @return
     */
    boolean support(Object target);
}
