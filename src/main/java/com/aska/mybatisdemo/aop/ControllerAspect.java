package com.aska.mybatisdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class ControllerAspect {
    @Pointcut("execution(public * com.aska.mybatisdemo.controller.*.*(..))")
    public void controllerMethodCall() {

    }

    @Before(value = "controllerMethodCall()")
    public void requestApiInfo(JoinPoint joinPoint) throws Exception {
        Method method = getControllerMethod(joinPoint);
        HttpServletRequest request = getRequestArg(joinPoint.getArgs());

        log.info("{}请求 | 请求方法：{}.{} | 请求url：{}",
                request.getMethod(), method.getDeclaringClass().getName(), method.getName(), request.getRequestURI());
    }

    private Method getControllerMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        return signature.getMethod();
    }

    private HttpServletRequest getRequestArg(Object[] args) throws Exception {
        HttpServletRequest request = null;

        if (args != null && args.length > 0) {
            for (Object arg : args) {
                if (arg instanceof HttpServletRequest) {
                    request = (HttpServletRequest) arg;
                    break;
                }
            }
        }

        if (request == null) {
            throw new Exception("global.ServiceInternalError");
        }

        return request;
    }
}
