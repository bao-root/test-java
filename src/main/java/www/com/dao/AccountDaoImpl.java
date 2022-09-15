package www.com.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import www.com.jdbc.Account;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YangXu
 * @description 用户模块接口实现类
 * @date 2022/09/14 17:30
 */
@Repository
public class AccountDaoImpl implements AccountDao{

    @Resource
    private JdbcTemplate jdbcTemplate;
    private String addSql = "insert into tb_account (account_name, account_type, account_money, " +
            "account_remark, create_time, update_time, user_id)" +
            "values (?, ?, ?, ?, now(), now(), ?)";
    String deleteSql = "delete from tb_account where account_id = ?";

    /**
     * 添加记录，返回影响行数
     * @param account
     * @return
     */
    @Override
    public int addAccount(Account account) {
        Object[] objs = {
                account.getAccountName(),
                account.getAccountType(),
                account.getAccountMoney(),
                account.getAccountRemark(),
                account.getUserId()
        };
        int row = jdbcTemplate.update(this.addSql, objs);
        return row;
    }

    /**
     * 添加账户，返回主键
     * @param account
     * @return
     */
    @Override
    public int addAccountKey(Account account) {
        // keyHolder对象用于获取数据库中的主键值
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection->{
            // 预编译sql语句，并设置返回主键
            PreparedStatement ps = connection.prepareStatement(this.addSql, Statement.RETURN_GENERATED_KEYS);
            // 设置参数
            ps.setString(1, account.getAccountName());
            ps.setString(2, account.getAccountType());
            ps.setDouble(3, account.getAccountMoney());
            ps.setString(4, account.getAccountRemark());
            ps.setInt(5, account.getUserId());
            // 返回预编译对象
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     * 批量添加账户，返回影响行数
     * @param accountList
     * @return
     */
    @Override
    public int addAccountBatch(List<Account> accountList) {
        int row = jdbcTemplate.batchUpdate(this.addSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Account account = accountList.get(i);
                // 设置参数
                ps.setString(1, account.getAccountName());
                ps.setString(2, account.getAccountType());
                ps.setDouble(3, account.getAccountMoney());
                ps.setString(4, account.getAccountRemark());
                ps.setInt(5, account.getUserId());
            }

            @Override
            public int getBatchSize() {
                return accountList.size();
            }
        }).length;
        return row;
    }

    /**
     * 查询用户账户数量，返回总数
     * @param userId
     * @return
     */
    @Override
    public int queryAccountCount(int userId) {
        String querySql = "select count(1) from tb_account where user_id = ?";
        Integer count = jdbcTemplate.queryForObject(querySql, Integer.class, userId);
        return count;
    }

    /**
     * 查询执行账户详情，返回账户对象
     * @param accountId
     * @return
     */
    @Override
    public Account queryAccountById(int accountId) {

        String querySql = "select * from tb_account where account_id = ?";
        Account account = jdbcTemplate.queryForObject(querySql, (resultSet, rowNum)->{
            return new Account(
                    accountId,
                    resultSet.getString("account_name"),
                    resultSet.getString("account_type"),
                    resultSet.getDouble("account_money"),
                    resultSet.getString("account_remark"),
                    resultSet.getString("create_time"),
                    resultSet.getString("update_time"),
                    resultSet.getInt("user_id")
            );
        }, accountId);
        return account;
    }

    /**
     * 多条查询，返回满足条件集合
     * @param userId 账户id
     * @param accountName 账户名
     * @param accountType 账户类型
     * @param createDate 创建时间
     * @return
     */
    @Override
    public List<Account> queryAccountByParams(Integer userId, String accountName, String accountType, String createDate) {
        String querySql = "select * from tb_account where user_id = ?";
        // 定义参数列表
        List<Object> params = new ArrayList<>();
        params.add(userId);
        if(StringUtils.isNoneBlank(accountName)){
            querySql += " and account_name like concat('%',?,'%')";
            params.add(accountName);
        }
        if(StringUtils.isNoneBlank(accountType)){
            querySql += " and account_type = ?";
            params.add(accountType);
        }
        if(StringUtils.isNoneBlank(createDate)){
            querySql += " and create_time < ?";
            params.add(createDate);
        }
        //定义查询参数
        Object[] objs = params.toArray();
        // 查询集合
        List<Account> accountList = jdbcTemplate.query(querySql, objs,(resultSet, rowNum)->{
            return new Account(
                    resultSet.getInt("account_id"),
                    resultSet.getString("account_name"),
                    resultSet.getString("account_type"),
                    resultSet.getDouble("account_money"),
                    resultSet.getString("account_remark"),
                    resultSet.getString("create_time"),
                    resultSet.getString("update_time"),
                    resultSet.getInt("user_id")
            );
        });
        return accountList;
    }

    /**
     * 更新账户，返回影响行数
     * @param account
     * @return
     */
    @Override
    public int updateAccount(Account account) {
        String updateSql = "update tb_account set account_name = ?, account_type = ?, account_money = ?,  " +
                "account_remark =?, update_time = now(),user_id = ? where account_id =?";
        if(!this.isExist(account.getAccountId())){
            return -1;
        }
        Object[] obj = {
                account.getAccountName(),
                account.getAccountType(),
                account.getAccountMoney(),
                account.getAccountRemark(),
                account.getUserId(),
                account.getAccountId()
        };
        return jdbcTemplate.update(updateSql, obj);
    }

    /**
     * 批量更新账户，返回影响行数
     * @param accountList
     * @return
     */
    @Override
    public int updateAccountBatch(List<Account> accountList) {
        String updateSql = "update tb_account set account_name = ?, account_type = ?, account_money = ?,  " +
                "account_remark =?, update_time = now(),user_id = ? where account_id =?";
        int row = jdbcTemplate.batchUpdate(updateSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Account account = accountList.get(i);
                // 设置参数
                ps.setString(1, account.getAccountName());
                ps.setString(2, account.getAccountType());
                ps.setDouble(3, account.getAccountMoney());
                ps.setString(4, account.getAccountRemark());
                ps.setInt(5, account.getUserId());
                ps.setInt(6, account.getAccountId());
            }
            @Override
            public int getBatchSize() {
                return accountList.size();
            }
        }).length;
        return row;
    }

    /**
     * 根据account_id删除账户
     * @param accountId
     * @return
     */
    @Override
    public int deleteAccount(int accountId) {
        Object[] objs ={accountId};
        return jdbcTemplate.update(this.deleteSql, objs);
    }

    @Override
    public int deleteAccountBatch(Integer[] accountIds) {
        int row = jdbcTemplate.batchUpdate(this.deleteSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, accountIds[i]);
            }
            @Override
            public int getBatchSize() {
                return accountIds.length;
            }
        }).length;
        return row;
    }

    /**
     * 根据account_id查询账户是否存在，返回boolean
     * @param account_id
     * @return Boolean
     */
    @Override
    public boolean isExist(int account_id){
        String sql = "select count(1) from tb_account where account_id = ?";
        Boolean is = jdbcTemplate.queryForObject(sql, Boolean.class, account_id);
        return is;
    }
}


