package www.com.transferTest;

import org.junit.Test;
import www.com.base.JdbcTestBase;
import www.com.service.AccountService;

import javax.annotation.Resource;

/**
 * @author YangXu
 * @description ’Àªß◊™’À≤‚ ‘¿‡
 * @date 2022/09/15 16:03
 */
public class AccountTransfer extends JdbcTestBase {

    @Resource
    private AccountService accountService;

    @Test
    public void inAccount(){
        int i = super.accountDao.inAccount(6, 00.00);
        System.out.println(i);
    }

    @Test
    public void updateAccountByTransfer(){
        int i = accountService.updateAccountByTransfer(8, 14, 10000.00);
        System.out.println(i);
    }

}





