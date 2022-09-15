package www.com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author YangXu
 * @description 日志切面
 * @date 2022/09/13 15:08
 *
 * 切面是由：切入点和通知组成
 *     切入点：定义要拦截哪些类的哪些方法
 *     通知： 定义拦截之后执行的逻辑
 */
//@Component
//@Aspect // 声明当前类为一个切面
public class LogCut {

    /**
     * 切入点：设置匹配拦截规则
     * 使用@Pointcut进行声明参数为匹配规则
     * 切入点表达式：execution(* www.com.service.*.*(..))
     *      第一个 * ：修饰符范围（public \ private \ protected \ *） *代表所有
     *      www.com.service：代表指定包
     *      .*.*: 代表所有类下的所有方法
     *      ..*.*: 代表当前包下的子包的任意类和任意方法
     *      (..): 方法的参数
     */
    //@Pointcut("execution(* www.com.service..*.*(..))")
    public void cut(){

    }

    /**
     * 通过@Before声明前置通知，并将通知指定在切入点上
     * 目标类的执行前执行
     */
    //@Before("cut()")
    public void before(){
        System.out.println("before.....!");
    }

    /**
     * 通过@AfterReturning声明返回通知，并将通知指定在切入点上
     * 目标类执行无异常后执行
     */
    //@AfterReturning("cut()")
    public void beforeReturn(){
        System.out.println("beforeReturn.....!");
    }

    /**
     * 通过@AfterThrowing声明异常通知，并将通知指定在切入点上
     * 目标类执行出现异常时执行
     */
    //@AfterThrowing("cut()")
    public void afterThrow(){
        System.out.println("afterThrow......!");
    }

    /**
     * 通过@Around声明环绕通知，并将通知指定在切入点上
     * 目标类执行前后都可以执行，可以在目标类的前后定义环绕通知执行响应的逻辑
     * 需要通过显示调用的方法，否则无法访问指定的方法 通过ProceedingJoinPoint对象中的proceed()
     * @param pjp
     * @return
     */
    //@Around("cut()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("11111111111111111");
        Object obj = null;
        try{
            // 显示调用对应的方法
            obj = pjp.proceed();
            int a = 1/0;
            System.out.println("around......!222222222222");
        }catch (Throwable throwable){
            throwable.fillInStackTrace();
            System.out.println("around error....!33333333333");
        }
        System.out.println("44444444444444444");
        return obj;
    }

    /**
     * 通过@After声明最终通知，并将通知指定在切入点上
     * 不管目标类执行是否异常都会执行
     */
    //@After("cut()")
    public void after(){
        System.out.println("after......!");
    }

}
