package org.example.springbootdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentControllerAOP {
//    @Pointcut
    private static int count = 0;
    @Before(" execution(* org.example.springbootdemo.controller.StudentController.*(..))")
    public void beforeShowCreateForm(JoinPoint joinPoint){
        count++;
        System.out.printf("""
                Before %s invoked - %d times
                """, joinPoint.getSignature().getName(), count);
    }
    @After(" execution(* org.example.springbootdemo.controller.StudentController.*(..))")
    public void afterShowCreateForm(JoinPoint joinPoint){
        System.out.printf("""
                After %s invoked
                """, joinPoint.getSignature().getName());
    }
}
