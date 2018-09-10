package source.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LogToCloud {

    @Before("execution(* add*(..))")
    public void beforeAddAdvice(JoinPoint joinPoint){
        System.out.println("WE ARE LOGGING TO CLOUD FIRST !!!!");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        System.out.println("Parameters: ");
        Object[] object = joinPoint.getArgs();

        for(Object args: object){
            System.out.println(args);
        }
        System.out.println();
    }

}
