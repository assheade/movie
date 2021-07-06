package com.chuanmei.movie.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式调用
public class Result<T> {
    private Boolean success; //true成功  false失败
    private Integer code; //状态码
    private String message; //消息
    private T data; //数据

    public static <T> Result<T> createResult(Boolean success, Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setSuccess(success);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(String message) {
        return createResult(true, 200, message, null);
    }
    public static <T> Result<T> success(T data) {
        return createResult(true, 200, "请求成功!", data);
    }
    public static <T> Result<T> success(String msg, T data) {
        return createResult(true, 200, msg, data);
    }

    public static <T> Result<T> fail(String msg) {
        return createResult(false, 400, msg, null);
    }

    public static <T> Result<T> fail(Integer code, String msg) {
        return createResult(false, code, msg, null);
    }

    public static <T> Result<T> fail(Integer code, String msg, T data) {
        return createResult(false, code, msg, data);
    }
}
