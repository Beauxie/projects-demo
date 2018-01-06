package com.beauxie.param.demo.web;

import com.beauxie.param.demo.annotation.ParamCheck;
import com.beauxie.param.demo.common.Result;
import com.beauxie.param.demo.enums.EnumResultCode;
import com.beauxie.param.demo.utils.ResponseMsgUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Beauxie
 * @date Created on 2018/1/6
 */
@RestController
public class HelloController {
    /**
     *测试@RequestParam注解
     * @param name
     * @return
     */
    @GetMapping("/hello1")
    public Result<String> hello1(@RequestParam String name) {
        return ResponseMsgUtil.builderResponse(EnumResultCode.SUCCESS.getCode(), "请求成功", "Hello," + name);
    }

    /**
     * 测试@ParamCheck注解
     * @param name
     * @return
     */
    @GetMapping("/hello2")
    public Result<String> hello2(@ParamCheck String name) {
        return ResponseMsgUtil.builderResponse(EnumResultCode.SUCCESS.getCode(), "请求成功", "Hello," + name);
    }

    /**
     * 测试@ParamCheck与@RequestParam一起时
     * @param name
     * @return
     */
    @GetMapping("/hello3")
    public Result<String> hello3(@ParamCheck @RequestParam String name) {
        return ResponseMsgUtil.builderResponse(EnumResultCode.SUCCESS.getCode(), "请求成功", "Hello," + name);
    }
}
