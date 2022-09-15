package www.com.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import www.com.dao.AccountDao;

import javax.annotation.Resource;

/**
 * @author YangXu
 * @description AccountService层
 * @date 2022/09/15 15:44
 */
@Service
public class AccountService {

    @Resource
    private AccountDao accountDao;

    /**
     *
     * @param outAccountId
     * @param inAccountId
     * @param accountMoney
     * @return
     */
    @Transactional(propagation = Propagation.MANDATORY)
    public int updateAccountByTransfer(Integer outAccountId, Integer inAccountId, Double accountMoney){
        int code = 0;
        if(accountMoney <= 0 ){
            return code;
        }
        int inRow = accountDao.inAccount(inAccountId, accountMoney);
        //int i = 1/0;
        int outRow = accountDao.outAccount(outAccountId, accountMoney);
        // todo 支出大于支出余额，收入继续往下执行
        if(inRow == 1 && outRow == 1){
            code = 1;
        }
        return code;
    }

}














