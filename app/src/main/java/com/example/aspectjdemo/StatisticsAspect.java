package com.example.aspectjdemo;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@org.aspectj.lang.annotation.Aspect
public class StatisticsAspect {
    @Pointcut("execution(@com.example.aspectjdemo.Statistics * *(..))")
    public void statisticsPointCut() {
    }

    @Around("statisticsPointCut()")
    public Object beginStatistics(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //获取类名
        String clzName = signature.getDeclaringType().getSimpleName();

        //获取方法名
        String methodName = signature.getName();

        //获取注解值
        String statisticsValue = signature.getMethod().getAnnotation(Statistics.class).value();

        Log.e("lianwenhong", String.format("统计到 %s方法的执行 统计值为%s", methodName, statisticsValue));

        return joinPoint.proceed();
    }
}
