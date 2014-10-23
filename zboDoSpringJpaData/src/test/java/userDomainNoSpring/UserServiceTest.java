package userDomainNoSpring;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class UserServiceTest {
    private String userId;

    public void saveAccount(){
        UserInfo userInfo=new UserServiceImpl().createNewUser("may","may-pass");
        new UserServiceImpl().createNewAccount("Credit-Card",userInfo);
        this.userId=userInfo.getId();
        Assert.assertTrue(this.userId.contentEquals("1"));
    }
    @Test
    public void findUserTest(){
        UserInfo user=new UserServiceImpl().findUserByID("1");
        Assert.assertTrue(user.getUsername().equals("may"));
    }

    @Test
    public void updateUserpasswordTest(){
        UserInfo userInfoReturn=new UserDaoImpl().findUser(userId);
        userInfoReturn.setPassword("new-password");
        new UserDaoImpl().updateUser(userInfoReturn);
        String password=new UserDaoImpl().findUser(userId).getPassword();
        Assert.assertTrue(password.contentEquals("new-password"));
    }

    @Test public void cascadePersistAccountTest(){
        UserInfo user=new UserServiceImpl().findUserByID("1");
        AccountInfo accountInfo=new AccountInfo("gas account",user);
        CreditCardInfo c1=new CreditCardInfo(2201L,"ICBC");
        CreditCardInfo c2=new CreditCardInfo(2202L,"CBC");
        ArrayList<CreditCardInfo> cardList =new ArrayList();
        cardList.add(c1);
        cardList.add(c2);
        accountInfo.setCreditCardInfos(cardList);
        new UserDaoImpl().saveAccount(accountInfo);
    }
    @Test public void cascadePersistAccount2Test(){
        UserInfo user=new UserServiceImpl().findUserByID("1");
        AccountInfo accountInfo=new AccountInfo("water account",user);
        CreditCardInfo c1=new CreditCardInfo(2203L,"ABC");
        CreditCardInfo c2=new CreditCardInfo(2204L,"BBC");
        CreditCardInfo c3=new CreditCardInfo(2205L,"CBC");
        ArrayList<CreditCardInfo> cardList =new ArrayList();
        cardList.add(c1);
        cardList.add(c2);
        cardList.add(c3);
        accountInfo.setCreditCardInfos(cardList);
        new UserDaoImpl().saveAccount(accountInfo);
    }

    @BeforeSuite
    public void dropAllTablesTest(){
        TableDroperImpl droper = new TableDroperImpl();
        droper.dropAllTablesBeforeTest();
        this.saveAccount();
    }
}
