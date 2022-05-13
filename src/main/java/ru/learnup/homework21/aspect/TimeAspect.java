package ru.learnup.homework21.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
@Slf4j
public class TimeAspect {

    @Around("@annotation(ru.learnup.homework21.annotation.WorkTime)")
    public Object logTimeData(ProceedingJoinPoint point) throws Throwable {
        long start = Instant.now().toEpochMilli();
        String methodName = point.getSignature().getName();
        Object returnedValue = point.proceed();
        long end = Instant.now().toEpochMilli();
        long time = end - start;
        log.info("{} method invoked by {}ms.", methodName, time);
        return returnedValue;
    }
}
