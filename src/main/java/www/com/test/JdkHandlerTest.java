package www.com.test;

import www.com.proxy.JdkHandler;
import www.com.proxy.Marry;
import www.com.proxy.MarryImpl;

/**
 * @author YangXu
 * @description JDK动态代理测试类
 * @date 2022/09/13 00:51
 */
public class JdkHandlerTest {
    public static void main(String[] args) {
        MarryImpl marry = new MarryImpl();
        Marry marryObj = (Marry) new JdkHandler(marry).getProxy();
        marryObj.toMarry();

    }
}
