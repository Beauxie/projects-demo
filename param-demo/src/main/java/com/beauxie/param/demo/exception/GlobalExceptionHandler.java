package com.beauxie.param.demo.exception;

import com.beauxie.param.demo.common.Result;
import com.beauxie.param.demo.enums.EnumResultCode;
import com.beauxie.param.demo.utils.ResponseMsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理.
 * 一般情况下，方法都有异常处理机制，但不能排除有个别异常没有处理，导致返回到前台，因此在这里做一个异常拦截，统一处理那些未被处理过的异常
 *
 * @author Beauxie
 * @date Created on 2017/1/6
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 参数为空异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class, ParamIsNullException.class})
    public Result<String> requestMissingServletRequest(Exception ex) {
        LOGGER.error("request Exception:", ex);
        return ResponseMsgUtil.builderResponse(EnumResultCode.FAIL.getCode(), ex.getMessage(), null);
    }

    /**
     * 特别说明： 可以配置指定的异常处理,这里处理所有
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result<String> errorHandler(HttpServletRequest request, Exception e) {
        LOGGER.error("request Exception:", e);
        return ResponseMsgUtil.exception();
    }
}
