package userDomain;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public UserInfo createNewUser(String user, String pwd){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(user);
        userInfo.setPassword(pwd);
        return userDao.saveUser(userInfo);
    }

    public AccountInfo createNewAccount(String type,UserInfo userInfo){
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountType(type);
        accountInfo.setUserinfo(userInfo);
        return userDao.saveAccount(accountInfo);
    }
}
