package com.eden.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.eden..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void logAfterRequestMapping(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method {} in {} was called with arguments {}", methodName, className, args);
    }

    @After("execution(* com.eden..*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void logAfterPostMapping(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        logger.info("POST method {} in {} was called with arguments {}", methodName, className, args);
    }

    // 类似的，可以添加更多的日志记录方法，记录特定的操作
}
