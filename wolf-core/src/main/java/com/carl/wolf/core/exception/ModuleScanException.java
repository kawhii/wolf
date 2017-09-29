/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package com.carl.wolf.core.exception;

/**
 * 模块扫描异常
 *
 * @author Carl
 * @date 2017/9/16
 * @since 1.0.0
 */
public class ModuleScanException extends ScanException {
    public ModuleScanException(Object target) {
        super(target);
    }

    public ModuleScanException(String message, Object target) {
        super(message, target);
    }

    public ModuleScanException(String message, Throwable cause, Object target) {
        super(message, cause, target);
    }

    public ModuleScanException(Throwable cause, Object target) {
        super(cause, target);
    }

    public ModuleScanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Object target) {
        super(message, cause, enableSuppression, writableStackTrace, target);
    }
}
