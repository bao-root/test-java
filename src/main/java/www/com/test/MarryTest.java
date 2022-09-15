package www.com.test;

import www.com.proxy.MarryImpl;
import www.com.proxy.MarryProxy;

/**
 * @author YangXu
 * @description 测试Marry类
 * @date 2022/09/12 20:53
 */
public class MarryTest {
    public static void main(String[] args) {

        MarryImpl marry = new MarryImpl();

        new MarryProxy(marry).toMarry();

    }
}
