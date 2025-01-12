package com.mirror.framework.common.exception;

/**
 * @author mirror
 */
public interface BaseExceptionInterface {

    // 获取异常码
    String getErrorCode();

    // 获取异常信息
    String getErrorMessage();
}
