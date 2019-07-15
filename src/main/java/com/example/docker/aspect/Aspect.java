package com.example.docker.aspect;

import com.example.docker.annotation.CacheLock;
import com.example.docker.annotation.CacheParameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author linyongjin
 * @date 2019/7/15 16:52
 */
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut(value = "execution(* com.example.docker.controller.DockerController.*(..))")
    public void pointCut() {

    }

    @AfterReturning(pointcut = "pointCut()")
    public void getCacheLock(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CacheLock cacheLock = method.getAnnotation(CacheLock.class);
        Object[] args = joinPoint.getArgs();
        System.out.println("-----args-----");
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("-----args-----");
        Parameter[] parameters = method.getParameters();
        System.out.println("-----parameters-----");
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
            CacheParameter annotation = parameter.getAnnotation(CacheParameter.class);
            System.out.println(annotation.parameterName());
        }
        System.out.println("-----parameters-----");
        System.out.println(cacheLock.lockName());
        System.out.println(cacheLock.timeout());
    }
}
