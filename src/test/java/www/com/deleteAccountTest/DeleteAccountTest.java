package www.com.deleteAccountTest;

import org.junit.Test;
import www.com.base.JdbcTestBase;

/**
 * @author YangXu
 * @description ɾ���˻�������
 * @date 2022/09/14 17:57
 */
public class DeleteAccountTest extends JdbcTestBase {

    /**
     * ����account_id����ɾ��������Ӱ������
     */
    @Test
    public void deleteAccount(){
        int i = super.accountDao.deleteAccount(7);
        System.out.println(i);
    }

    /**
     * ����account_id��������ɾ��������Ӱ������
     */
    @Test
    public void deleteAccountBatch(){
        Integer[] ids = {1, 2};
        int i = super.accountDao.deleteAccountBatch(ids);
        System.out.println(i);
    }
}
