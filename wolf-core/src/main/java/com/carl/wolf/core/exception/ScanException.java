/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.exception;

/**
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public abstract class ScanException  extends CoreException {
    private Object target;

    public ScanException(Object target) {
        this.target = target;
    }

    public ScanException(String message, Object target) {
        super(message);
        this.target = target;
    }

    public ScanException(String message, Throwable cause, Object target) {
        super(message, cause);
        this.target = target;
    }

    public ScanException(Throwable cause, Object target) {
        super(cause);
        this.target = target;
    }

    public ScanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object target) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.target = target;
    }
}
