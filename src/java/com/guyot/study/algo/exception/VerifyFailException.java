package com.guyot.study.algo.exception;

/**
 * @author guyot
 * @version 1.0.0-SNAPSHOT
 * @desc 验证失败异常
 * @date 2020/12/23
 */
public class VerifyFailException extends RuntimeException {

    public VerifyFailException(String message) {
        super(message);
    }

    public VerifyFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifyFailException(Throwable cause) {
        super(cause);
    }

}
