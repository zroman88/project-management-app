package com.romz.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author roman - Project project-management
 */
@Aspect
@Component
public class ApplicationLoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.romz.pma.controllers..*)")
    public void definePackagePointcuts() {
        // empty method to name the location specified in the pointcut
    }

    @After("definePackagePointcuts()")
    public void logBefore(JoinPoint jp) {
        log.debug("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        log.debug(("-------Before Method Execution------- \n {}.{}() {}"),
                  jp.getSignature().getDeclaringType(),
                  jp.getSignature().getName(),
                  Arrays.toString(jp.getArgs()));
        log.debug("---------------------------------------------");
    }
}
