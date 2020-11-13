package com.fengwenyi.springbootaop.aspect;

import com.fengwenyi.springbootaop.annoation.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Erwin Feng
 * @since 2020-11-13
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    /*@Before("@annotation(log)")
    public void before(ProceedingJoinPoint joinPoint, Log log) {

    }*/

    @Around("@annotation(annotation)")
    public Object around(ProceedingJoinPoint joinPoint, Log annotation) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        log.info("{} start", method.getName());
        Object proceed = joinPoint.proceed();
        log.info("{} end", method.getName());
        return proceed;
    }

}
