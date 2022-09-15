package www.com.test;

import www.com.proxy.CglibInterceptor;
import www.com.proxy.MarryImpl;

/**
 * @author YangXu
 * @description Cglib动态代理测试类
 * @date 2022/09/13 11:26
 */
public class CglibInterceptorTest {
    public static void main(String[] args) {
        MarryImpl marry = new MarryImpl();
        MarryImpl cglibObj = (MarryImpl) new CglibInterceptor(marry).getProxy();
        cglibObj.toMarry();
    }
}
