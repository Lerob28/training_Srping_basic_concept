package main.aop.aspects;


import main.aop.model.Comment;
import main.aop.utils.Tolog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
@Aspect
@Order(2)
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(main.aop.utils.Tolog)")
   public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Comment comment = new Comment();
        comment.setText("Some other text!");
        comment.setAuthor("Spring AOP");
        Object [] newArguments = {comment};

        logger.info("Method "+ methodName+" With parameters"+ Arrays.asList(args)+" will be executed ...");
        Object returnedByCallingMethod = joinPoint.proceed(newArguments);
        logger.log(Level.WARNING, "Method executed and returned "+returnedByCallingMethod+" !");
        return returnedByCallingMethod;
   }

    /*@Around("execution(* main.aop.service.*.*(..))")
   public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        Comment comment = new Comment();
        comment.setText("Some other text!");
        comment.setAuthor("Spring AOP");
        Object [] newArguments = {comment};

        logger.info("Method "+ methodName+" With parameters"+ Arrays.asList(args)+" will be executed ...");
        Object returnedByCallingMethod = joinPoint.proceed(newArguments);
        logger.log(Level.WARNING, "Method executed and returned "+returnedByCallingMethod+" !");
        return returnedByCallingMethod;
    }*/
}
