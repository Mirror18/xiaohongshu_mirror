package com.mirror.xiaohongshu.distributed.id.generator.biz.core.snowflake.exception;

public class ClockGoBackException extends RuntimeException {
    public ClockGoBackException(String message) {
        super(message);
    }
}
