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
public class ModuleScanException extends CoreException {

    public ModuleScanException() {
    }

    public ModuleScanException(String message) {
        super(message);
    }

    public ModuleScanException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModuleScanException(Throwable cause) {
        super(cause);
    }

    public ModuleScanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
