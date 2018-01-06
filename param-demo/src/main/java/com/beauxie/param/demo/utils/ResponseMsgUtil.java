package com.beauxie.param.demo.utils;

import com.beauxie.param.demo.common.Result;
import com.beauxie.param.demo.enums.EnumResultCode;

/**
 * @author Beauxie
 * @date Created on 2018/1/6
 */
public class ResponseMsgUtil {

    /**
     * 根据消息码等生成接口返回对象
     *
     * @param code 结果返回码
     * @param msg  结果返回消息
     * @param data 数据对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> builderResponse(int code, String msg, T data) {
        Result<T> res = new Result<>();
        res.setResCode(code);
        res.setResMsg(msg);
        res.setData(data);
        return res;
    }

    /**
     * 请求异常返回结果
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> exception() {
        return builderResponse(EnumResultCode.INTERNAL_SERVER_ERROR.getCode(), "服务异常", null);
    }

}
