package ru.learnup.homework21.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("@annotation(ru.learnup.homework21.annotation.LogMethod)")
    public void log(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        Object returnedValue = point.proceed();
        List<String> args = Arrays.stream(point.getArgs())
                .map(Object::toString)
                .collect(Collectors.toList());
        log.info("Invoked method: {}, worked with params {} and return value {}", methodName, args, returnedValue);

    }
}
