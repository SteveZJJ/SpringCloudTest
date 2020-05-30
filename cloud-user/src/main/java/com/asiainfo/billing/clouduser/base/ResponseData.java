package com.asiainfo.billing.clouduser.base;

/**
 * @Description RestApi 返回数据
 * @Author sugar
 * @Date 2019/8/9 4:32 PM
 * @Version 1.0
 */
public class ResponseData<T> {

    private int code = 200;

    private String message = "success";

    private T data;

    public ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseData(T data) {
        this.data = data;
    }

    public ResponseData() {
    }

    public ResponseData(String message) {
        this.message = message;
    }


    public ResponseData<T> success(T data) {
        this.data = data;
        return this;

    }

    public ResponseData<T> success(T data, String message) {
        this.data = data;
        this.message = message;
        return this;
    }

    public ResponseData<T> fail(String message) {
        this.code = ResponseCodeEnum.SERVER_ERROR_CODE.getCode();
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseData<T> fail(String message, ResponseCodeEnum code) {
        this.code = code.getCode();
        this.message = message;
        return this;
    }

    public ResponseData<T> fail(String message, int code) {
        this.code = code;
        this.message = message;
        return this;
    }
}
