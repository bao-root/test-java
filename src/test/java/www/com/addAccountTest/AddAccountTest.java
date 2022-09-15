package www.com.addAccountTest;

import org.junit.Test;
import www.com.base.JdbcTestBase;
import www.com.dao.AccountDao;
import www.com.jdbc.Account;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXu
 * @description 添加账户测试类
 * @date 2022/09/14 17:53
 */
public class AddAccountTest extends JdbcTestBase {

    private Account account;

    /**
     * 添加一条账户，返回影响行数
     */
    @Test
    public void addAccountTest(){
        account = new Account("李四","中国建设银行", 3466.00,"",1);
        int row = super.accountDao.addAccount(account);
        System.out.println(row);
    }

    /**
     * 添加一条账户，返沪主键
     */
    @Test
    public void addAccountHasKey(){
        account = new Account("叙宝","中国工商银行", 5416.00,"",5);
        int hasKet = super.accountDao.addAccountKey(account);
        System.out.println(hasKet);
    }

    /**
     * 添加多个账户，返回影响行数
     */
    @Test
    public void addAccountBatch(){
        Account account1 = new Account("赵明","中国银行", 3446.00,"",4);
        Account account2 = new Account("刘泽涛","中国交通银行", 1410.00,"",6);
        Account account3 = new Account("小不点","中国招商银行", 5210.00,"",5);
        List<Account> accountList= new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        int row = super.accountDao.addAccountBatch(accountList);
        System.out.println(row);

    }
}








