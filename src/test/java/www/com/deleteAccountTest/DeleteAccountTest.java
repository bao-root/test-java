package www.com.deleteAccountTest;

import org.junit.Test;
import www.com.base.JdbcTestBase;

/**
 * @author YangXu
 * @description 删除账户测试类
 * @date 2022/09/14 17:57
 */
public class DeleteAccountTest extends JdbcTestBase {

    /**
     * 根据account_id进行删除，返回影响行数
     */
    @Test
    public void deleteAccount(){
        int i = super.accountDao.deleteAccount(7);
        System.out.println(i);
    }

    /**
     * 根据account_id进行批量删除，返回影响行数
     */
    @Test
    public void deleteAccountBatch(){
        Integer[] ids = {1, 2};
        int i = super.accountDao.deleteAccountBatch(ids);
        System.out.println(i);
    }
}
