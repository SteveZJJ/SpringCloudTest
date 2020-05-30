package com.asiainfo.billing.clouduser.base;

/**
 * @Description RestApi 返回数据类
 * @Author sugar
 * @Date 2019/8/9 4:29 PM
 * @Version 1.0
 */
public class Response {


    private Response() {
    }

    /**
     * 返回空数据
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> success() {
        ResponseData<E> res = new ResponseData<E>();
        res.success(null);
        return res;
    }

    /**
     * 装在data
     * @param data
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> success(E data) {
        ResponseData<E> res = new ResponseData<E>();
        res.success(data);
        return res;
    }

    /**
     * 装在data 并设置message
     * @param data
     * @param message
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> ok(E data, String message) {
        ResponseData<E> res = new ResponseData<E>();
        res.success(data, message);
        return res;
    }

    /**
     * 返回错误 默认500错误
     * @param message
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> fail(String message) {
        ResponseData<E> res = new ResponseData<E>();
        res.fail(message);
        return res;
    }

    /**
     * 参数错误
     * @param message
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> failByParams(String message) {
        ResponseData<E> res = new ResponseData<E>();
        res.fail(message);
        res.setCode(ResponseCodeEnum.PARAM_ERROR_CODE.getCode());
        return res;
    }

    /**
     * 传异常枚举
     * @param message
     * @param code
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> fail(String message, ResponseCodeEnum code) {
        ResponseData<E> res = new ResponseData<E>();
        res.fail(message, code);
        return res;
    }

    /**
     * 动态传code以及message
     * @param message
     * @param code
     * @param <E>
     * @return
     */
    public static <E> ResponseData<E> fail(String message, int code) {
        ResponseData<E> res = new ResponseData<E>();
        res.fail(message, code);
        return res;
    }


}
