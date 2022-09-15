package www.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author YangXu
 * @description 动态代理类
 * @date 2022/09/13 00:26
 */
// InvocationHandler继承他必须实现invoke方法，通过底层去调用目标对象中的方法
public class JdkHandler implements InvocationHandler {

    // 创建一个目标对象
    private Object target;

    // 通过构造器传递目标对象
    public JdkHandler(Object target){
        this.target = target;
    }

    /**
     * newProxyInstance传递三个参数
     * 1、loader：当前类的加载器
     * 2、interface: 当前接口数组  this.target.getClass().getInterfaces()目标对象的接口数组
     * 3、InvocationHandler接口： 传入InvocationHandler接口的实现类，当前类实现该接口，所以当前类就是InvocationHandler的实现类，所以传递this即可
     * @return 返回目标对象
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), this.target.getClass().getInterfaces(),this);
    }

    /**
     * 1、调用目标对对象的方法（返回object）
     * 2、增强目标对象的行为
     * @param proxy 调用该方法的代理实现
     * @param method 目标对象的方法
     * @param args 目标对象的方法所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 用户的增强行为
        System.out.println("before.......!!!");
        // 调用目标对象的方法
        Object obj = method.invoke(target, args);
        // 用户增强行为
        System.out.println("after.......!!!");

        return obj;
    }
}
