package www.com.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.com.dao.AccountDao;

import javax.annotation.Resource;

/**
 * @author YangXu
 * @description JDBC测试基类
 * @date 2022/09/14 17:50
 */
@RunWith(SpringJUnit4ClassRunner.class) // 将测试运行在spring测试换进中
@ContextConfiguration(locations = {"classpath:spring4.xml"}) // 设置需要加载的配置文件
public class JdbcTestBase {
    @Resource
    protected AccountDao accountDao;
}
