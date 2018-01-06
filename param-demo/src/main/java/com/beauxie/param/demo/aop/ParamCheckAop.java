package com.beauxie.param.demo.aop;

import com.beauxie.param.demo.annotation.ParamCheck;
import com.beauxie.param.demo.exception.ParamIsNullException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Beauxie
 * @date Created on 2017/1/6
 */
@Component
@Aspect
public class ParamCheckAop {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 定义有一个切入点，范围为web包下的类
     */
    @Pointcut("execution(public * com.beauxie.param.demo.web..*.*(..))")
    public void checkParam() {
    }

    @Before("checkParam()")
    public void doBefore(JoinPoint joinPoint) {
    }

    /**
     * 检查参数是否为空
     */
    @Around("checkParam()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature signature = ((MethodSignature) pjp.getSignature());
        //得到拦截的方法
        Method method = signature.getMethod();
        //获取方法参数注解，返回二维数组是因为某些参数可能存在多个注解
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (parameterAnnotations == null || parameterAnnotations.length == 0) {
            return pjp.proceed();
        }
        //获取方法参数名
        String[] paramNames = signature.getParameterNames();
        //获取参数值
        Object[] paranValues = pjp.getArgs();
        //获取方法参数类型
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (int j = 0; j < parameterAnnotations[i].length; j++) {
                //如果该参数前面的注解是ParamCheck的实例，并且notNull()=true,则进行非空校验
                if (parameterAnnotations[i][j] != null && parameterAnnotations[i][j] instanceof ParamCheck && ((ParamCheck) parameterAnnotations[i][j]).notNull()) {
                    paramIsNull(paramNames[i], paranValues[i], parameterTypes[i] == null ? null : parameterTypes[i].getName());
                    break;
                }
            }
        }
        return pjp.proceed();
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint
     */
    @AfterReturning("checkParam()")
    public void doAfterReturning(JoinPoint joinPoint) {
    }

    /**
     * 参数非空校验，如果参数为空，则抛出ParamIsNullException异常
     * @param paramName
     * @param value
     * @param parameterType
     */
    private void paramIsNull(String paramName, Object value, String parameterType) {
        if (value == null || "".equals(value.toString().trim())) {
            throw new ParamIsNullException(paramName, parameterType);
        }
    }

}
