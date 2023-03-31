package com.esprit.kaddem.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspects {
    @Around("execution(* com.esprit.kaddem.services.ContratService.retrieveAndUpdateStatusContrat(..))")
    public void exec(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String name = proceedingJoinPoint.getSignature().getName();
        Object object = proceedingJoinPoint.proceed();
        log.info("Around Out "+name);
    }

    @Before("execution(* com.esprit.kaddem.services.*.*(..))")
    public void beforeMethode(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In Method "+name);
    }
    @After("execution(* com.esprit.kaddem.services.*.*(..))")
    public void afterMethode(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of Method "+name);
    }
}
