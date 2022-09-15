package www.com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author YangXu
 * @description JDBC测试类
 * @date 2022/09/14 11:09
 */
@RunWith(SpringJUnit4ClassRunner.class) // 将测试运行在spring测试换进中
@ContextConfiguration(locations = {"classpath:spring4.xml"}) // 设置需要加载的配置文件
public class JdbcTest2 {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTest(){
        String sql = "select * from tb_account";
        List<Map<String, Object>> mapList = this.jdbcTemplate.queryForList(sql);
        System.out.println(mapList);
    }
}
