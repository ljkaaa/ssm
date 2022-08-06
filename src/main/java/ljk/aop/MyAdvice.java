package ljk.aop;

import ljk.controller.Code;
import ljk.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    @Pointcut("execution(* ljk.service.*Service.selectById(..))")
    public void fun(){}

    @Before("fun()")
    public void function(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        if(Integer.parseInt(args[0].toString()) < 0){
            throw new BusinessException(Code.BUSINESS_ERR,"sb");
        }
    }
}
