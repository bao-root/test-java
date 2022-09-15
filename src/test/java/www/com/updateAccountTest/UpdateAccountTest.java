package www.com.updateAccountTest;

import org.junit.Test;
import www.com.base.JdbcTestBase;
import www.com.dao.AccountDaoImpl;
import www.com.jdbc.Account;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXu
 * @description 更新账户测试类
 * @date 2022/09/14 17:59
 */
public class UpdateAccountTest extends JdbcTestBase {

    /**
     * 账户查询，返回boolean
     */
    @Test
    public void isExist(){
        boolean is = super.accountDao.isExist(1);
        System.out.println(is);
    }

    @Test
    public void updateAccount(){
        Account account = new Account(
                11,
                "小宝",
                "中国工商银行银行",
                1314.00,
                "备注信息",
                "",
                "",
                5
        );
        int i = super.accountDao.updateAccount(account);
        System.out.println(i);
    }

    @Test
    public  void updateAccountBatch(){
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(
                1,
                "张宝",
                "中国工商银行银行",
                1614.40,
                "备注信息1",
                "",
                "",
                1
        ));
        accountList.add(new Account(
                2,
                "刘邰",
                "中国工商银行银行",
                1521.00,
                "",
                "",
                "",
                2
        ));
        int i = super.accountDao.updateAccountBatch(accountList);
        System.out.println(i);
    }
}












