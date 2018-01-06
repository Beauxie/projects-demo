package com.beauxie.param.demo.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * "参数不能为空"注解，作用于方法参数上。
 *
 * @author Beauxie
 * @date Created on 2017/1/6
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ParamCheck {
    /**
     * 是否非空,默认不能为空
     */
    boolean notNull() default true;
}
