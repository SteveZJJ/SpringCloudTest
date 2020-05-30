package com.asiainfo.billing.clouduser.base;

/**
 * @Description 返回code 枚举
 * @Author sugar
 * @Date 2019/8/9 4:50 PM
 * @Version 1.0
 */
public enum ResponseCodeEnum {
    /** 正确 **/
    SUCCESS_CODE(200),
    /** 1**/
    API_ERROR_CODE(10001),
    /** 参数错误 **/
    PARAM_ERROR_CODE(400),
    /** 限制调用 **/
    LIMIT_ERROR_CODE(401),
    /** token 过期 **/
    TOKEN_TIMEOUT_CODE(402),
    /** 禁止访问 **/
    NO_AUTH_CODE(403),
    /** 资源没找到 **/
    NOT_FOUND_CODE(404),
    /** 服务器错误 **/
    SERVER_ERROR_CODE(500),
    /** 服务降级中 **/
    DOWNGRADE(406),
    /** 异常回退 **/
    FALLBACK(407),
    /** 异常回退 **/
    NOLOGIN(10002);


    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    private ResponseCodeEnum(int code) {
        this.code = code;
    }

}
