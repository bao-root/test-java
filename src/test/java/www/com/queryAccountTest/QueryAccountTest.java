package www.com.queryAccountTest;

import org.junit.Test;
import www.com.base.JdbcTestBase;
import www.com.jdbc.Account;

import java.util.List;

/**
 * @author YangXu
 * @description 账户查询测试类
 * @date 2022/09/14 17:58
 */
public class QueryAccountTest extends JdbcTestBase {

    /**
     * 查询用户账户数量， 返回账户总数量
     */
    @Test
    public void queryAccountCount(){
        int count = accountDao.queryAccountCount(5);
        System.out.println(count);
    }

    /**
     * 查询执行账户详情，返回账户对象
     */
    @Test
    public void queryAccountById(){
        Account user = super.accountDao.queryAccountById(11);
        System.out.println(user);
    }

    @Test
    public void queryAccountByParams(){
        List<Account> accountList =super.accountDao.queryAccountByParams(5, null, null, "2022-9-15 3:00:00");
        System.out.println(accountList);
    }
}















