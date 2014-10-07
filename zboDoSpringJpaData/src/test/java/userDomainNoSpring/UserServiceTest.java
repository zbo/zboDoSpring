package userDomainNoSpring;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class UserServiceTest {
    private String userId;

    @Test
    public void saveAccountTest(){
        UserInfo userInfo=new UserServiceImpl().createNewUser("may","may-pass");
        new UserServiceImpl().createNewAccount("Credit-Card",userInfo);
        this.userId=userInfo.getId();
        Assert.assertTrue(this.userId.contentEquals("1"));
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
        AccountInfo accountInfo=new AccountInfo();
        CreditCardInfo c1=new CreditCardInfo(2201L,"ICBC");
        CreditCardInfo c2=new CreditCardInfo(2202L,"CBC");
        ArrayList<CreditCardInfo> cardList =new ArrayList();
        cardList.add(c1);
        cardList.add(c2);
        accountInfo.setCreditCardInfos(cardList);
        new UserDaoImpl().saveAccount(accountInfo);
    }

    @BeforeSuite
    public void dropAllTablesTest(){
        TableDroperImpl droper = new TableDroperImpl();
        droper.dropAllTablesBeforeTest();
    }
}
