package main.aop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* main.aop.service.*.*(..))")
   public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Method will be executed ...");
        joinPoint.proceed();
        logger.log(Level.WARNING, "Method executed ...");
        return null;
    }
}
