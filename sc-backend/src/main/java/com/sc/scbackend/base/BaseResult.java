package com.sc.scbackend.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable {

    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_FAIL = -1;

    private int status;

    private String message;

    private Object data;

    private long timestamp = System.currentTimeMillis();

    private static BaseResult createResult(int status, String message, Object result) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setData(result);
        return baseResult;
    }

    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", null);
    }

    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message, null);
    }


    public static BaseResult success(Object result) {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", result);
    }


    public static BaseResult success(String message, Object result) {
        return BaseResult.createResult(STATUS_SUCCESS, message, result);
    }


    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FAIL, "失败", null);
    }


    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FAIL, message, null);
    }


    public static BaseResult fail(String message, Object result) {
        return BaseResult.createResult(STATUS_FAIL, message, result);
    }
}
