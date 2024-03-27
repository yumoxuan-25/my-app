package com.yumoxuan.myapp.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    /**
     * 成功
     */
    public static final Integer SUCCESS_CODE = 200;
    /**
     * 系统异常
     */
    public static final Integer SYS_ERROR_CODE = 500;
    /**
     * 参数异常
     */
    public static final Integer PARAM_ERROR_CODE = 511;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result<T> ok() {
        Result<T> res = new Result<>();
        res.setCode(SUCCESS_CODE);
        res.setMessage("成功");
        return res;
    }

    /**
     * 系统异常
     *
     * @param message
     * @return
     */
    public Result<T> error500(String message) {
        this.setCode(SYS_ERROR_CODE);
        this.setMessage(message);
        return this;
    }

    /**
     * 参数异常
     *
     * @param message
     * @return
     */
    public Result<T> error511(String message) {
        this.setCode(SYS_ERROR_CODE);
        this.setMessage(message);
        return this;
    }
}
