package source.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Before("execution(public void source.dao.AccountDAO.addAccount(source.aop.Account))")
    public void beforeAddAccountAdvice(){
        System.out.println("Executing @Before advice on addAccount(Account)");
    }

    @Before("execution(* add*(..))")
    public void beforeAddAdvice(){
        System.out.println("Executing @Before advice on add*(..)");
    }



    @Pointcut("execution(* source.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("execution(* source.dao.*.get*(..))")
    private void forGetter(){}

    @Pointcut("execution(* source.dao.*.set*(..))")
    private void forSetter(){}

    //create pointcut include package but exclude getter/setter
    @Pointcut("forDAOPackage() && !(forSetter() || forGetter())")
    private void forDAOPackageNoGetterSetter(){}

    @Before("forDAOPackageNoGetterSetter()")
    public void doWork(){
        System.out.println("Doing some work");
    }
    @Before("forDAOPackageNoGetterSetter()")
    public void goToSleep(){
        System.out.println("I am going to sleep now");
    }



}
