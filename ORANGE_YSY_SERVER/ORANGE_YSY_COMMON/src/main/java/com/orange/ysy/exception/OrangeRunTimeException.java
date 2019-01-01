package com.orange.ysy.exception;

/**
 * 异常消息类
 *
 * @author ： wangxiaoliang
 * @Date: 2017年8月29日
 */
public class OrangeRunTimeException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String code = "-1";// 异常
    private String message;

    public String getErrorCode() {
        return code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrangeRunTimeException(String message) {
        this.message = message;
    }

}
