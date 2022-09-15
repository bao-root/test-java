package www.com.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author YangXu
 * @description JDBC测试类
 * @date 2022/09/14 11:09
 */
public class JdbcTest {
    @Test
    public void jdbcTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring4.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
        String sql = "select * from tb_account";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
        System.out.println(mapList);
    }
}
