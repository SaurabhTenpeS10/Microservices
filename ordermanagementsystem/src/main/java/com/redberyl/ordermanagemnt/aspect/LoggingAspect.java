package com.redberyl.ordermanagemnt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Pointcut to log all methods in controllers and services
    @Pointcut("execution(* com.redberyl.ordermanagemnt.controller..*(..)) || execution(* com.redberyl.ordermanagemnt.service..*(..))")
    public void applicationPointcut() {}

    // Log method entry
    @Before("applicationPointcut()")
    public void logMethodEntry(JoinPoint joinPoint) {
        logger.info("Entering Method: {} in Class: {}", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().getSimpleName());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            logger.info("Arguments: ");
            for (Object arg : args) {
                logger.info("    - {}", arg);
            }
        }
    }

    // Log method exit
    @AfterReturning(pointcut = "applicationPointcut()", returning = "result")
    public void logMethodExit(JoinPoint joinPoint, Object result) {
        logger.info("Exiting Method: {} in Class: {}", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().getSimpleName());
        if (result != null) {
            logger.info("Return Value: {}", result);
        }
    }

    // Log exceptions
    @AfterThrowing(pointcut = "applicationPointcut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in Method: {} in Class: {}", joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().getSimpleName());
        logger.error("Exception Message: {}", exception.getMessage());
    }

    // Log method execution time
    @Around("applicationPointcut()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method {} executed in {} ms", joinPoint.getSignature(), (endTime - startTime));
        return result;
    }
}

