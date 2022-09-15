package www.com.base;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import www.com.dao.AccountDao;

import javax.annotation.Resource;

/**
 * @author YangXu
 * @description JDBC���Ի���
 * @date 2022/09/14 17:50
 */
@RunWith(SpringJUnit4ClassRunner.class) // ������������spring���Ի�����
@ContextConfiguration(locations = {"classpath:spring4.xml"}) // ������Ҫ���ص������ļ�
public class JdbcTestBase {
    @Resource
    protected AccountDao accountDao;
}
