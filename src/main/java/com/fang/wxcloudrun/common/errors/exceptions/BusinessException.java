package com.fang.wxcloudrun.common.errors.exceptions;

/**
 * @author FPH
 * @since 2022年8月23日00:05:31
 * 业务异常处理
 */

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    private Object errData;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Object errData) {
        super(message);
        this.errData = errData;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public Object getErrData() {
        return this.errData;
    }

    public int getCode() {
        return code;
    }

}

