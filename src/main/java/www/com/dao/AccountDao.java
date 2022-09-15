package www.com.dao;

import www.com.jdbc.Account;

import java.util.List;

/**
 * @author YangXu
 * @description 用户模块接口定义
 * @date 2022/09/14 17:01
 * 1．添加账户
 *     添加账户记录，返回受影响的行数添
 *     添加账户记录，返回记录的主键
 *     批量添加账户记录，返回受影响的行数
 * 2．查询账户
 *     查询指定用户的账户总记录数，返回记录数
 *     查询指定账户记录详情，返回账户对象
 *     多条件查询指定用户的账户列表，返回账户集合
 * 3．更新账户
 *     更新账户记录，返回受影响的行数
 *     批量更新账户记录，返回受影响的行数
 * 4．删除账户
 *     删除账户记录，返回受影响的行数
 *     批量删除账户记录，返回受影响的行数
 */
public interface AccountDao {

    // 1、添加账户
    /**
     * 添加账户记录，返回受影响的行数添
     * @param account
     * @return
     */
    int addAccount(Account account);
    /**
     * 添加账户记录，返回记录的主键
     * @param account
     * @return
     */
    int addAccountKey(Account account);
    /**
     *  批量添加账户记录，返回受影响的行数
     * @param accountList
     * @return
     */
    int addAccountBatch(List<Account> accountList);

    // 2、查询账户
    /**
     * 查询指定用户的账户总记录数，返回记录数
     * @param userId
     * @return
     */
    int queryAccountCount(int userId);
    /**
     * 查询指定账户记录详情，返回账户对象
     * @param accountId
     * @return
     */
    Account queryAccountById(int accountId);
    /**
     * 多条件查询指定用户的账户列表，返回账户集合
     * @param userId 账户id
     * @param accountName 账户名
     * @param accountType 账户类型
     * @param createDate 创建时间
     * @return
     */
    List<Account> queryAccountByParams(Integer userId, String accountName, String accountType, String createDate);

    // 3、更新账户
    /**
     * 更新账户记录，返回受影响的行数
     * @param account
     * @return
     */
    int updateAccount(Account account);
    /**
     * 批量更新账户记录，返回受影响的行数
     * @param accountList
     * @return
     */
    int updateAccountBatch(List<Account> accountList);

    // 4、删除账户
    /**
     * 删除账户记录，返回受影响的行数
     * @param accountId
     * @return
     */
    int deleteAccount(int accountId);
    /**
     * 批量删除账户记录，返回受影响的行数
     * @param userIds
     * @return
     */
    int deleteAccountBatch(Integer[] userIds);

    // 5、其他处理函数
    boolean isExist(int account_id);
}
