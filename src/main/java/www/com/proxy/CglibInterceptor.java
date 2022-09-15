package www.com.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author YangXu
 * @description MethodInterceptor实现类
 * @date 2022/09/13 10:36
 */
public class CglibInterceptor implements MethodInterceptor {

    private Object target;

    /**
     * 通过构造器获取代理目标对象
     * @param target
     */
    public CglibInterceptor(Object target) {
        this.target = target;
    }

    /**
     * 生成代理对象
     * @return
     */
    public Object getProxy(){
        // 通过Enhancer中的create方法生成一个代理对象类，
        Enhancer enhancer = new Enhancer();
        // 将目标类作为代理父类
        enhancer.setSuperclass(target.getClass());
        // 设置拦截器 将本身作为回调
        enhancer.setCallback(this);
        // 生成代理对象返回给调用者
        return enhancer.create();
    }

    /**
     * 底层自动调用该方法作为拦截器，该方法主要调用目标对象的方法，并且增强目标行为
     * @param o cglib动态生成的代理类实例
     * @param method 实体类所调用方法的引用
     * @param objects 参数列表
     * @param methodProxy 生成的代理类方法的代理引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        // 增强行为
        System.out.println("before.......!");

        // 调用目标类中的方法
        Object obj = methodProxy.invoke(target, objects);

        System.out.println("after.......!");

        return obj;
    }
}
