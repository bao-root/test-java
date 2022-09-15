package www.com.jdbc;

/**
 * @author YangXu
 * @description 实体账户类
 * @date 2022/09/14 16:53
 */
public class Account {
    private Integer accountId; //主键
    private String accountName; //账户名
    private String accountType; //账户类型
    private Double accountMoney; //账户余额
    private String accountRemark; //备注
    private String createTime; //创建时间
    private String updateTime; //更新时间
    private Integer userId; //账户所属用户

    public Account() {
    }

    public Account(
            String accountName,
            String accountType,
            Double accountMoney,
            String accountRemark,
            Integer userId) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountMoney = accountMoney;
        this.accountRemark = accountRemark;
        this.userId = userId;
    }

    public Account(Integer accountId, String accountName, String accountType, Double accountMoney, String accountRemark, String createTime, String updateTime, Integer userId) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountMoney = accountMoney;
        this.accountRemark = accountRemark;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userId = userId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public String getAccountRemark() {
        return accountRemark;
    }

    public void setAccountRemark(String accountRemark) {
        this.accountRemark = accountRemark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", accountMoney=" + accountMoney +
                ", accountRemark='" + accountRemark + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}
