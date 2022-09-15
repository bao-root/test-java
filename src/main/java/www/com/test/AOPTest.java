package www.com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import www.com.service.UserService;

/**
 * @author YangXu
 * @description AOP测试类
 * @date 2022/09/13 16:02
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring4.xml");
        UserService userService = (UserService) ac.getBean("userService");
        userService.test();
    }
}
