package userDomainNoSpring;

/**
 * Created by twer on 14-10-6.
 */
public interface UserDao {
    public AccountInfo saveAccount(AccountInfo accountInfo);
    public UserInfo saveUser(UserInfo userInfo);
    public UserInfo findUser(String userId);
}
