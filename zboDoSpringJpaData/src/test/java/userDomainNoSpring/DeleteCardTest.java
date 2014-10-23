package userDomainNoSpring;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class DeleteCardTest {
    UserInfo userInfo;
    @Test
    public void deleteCreditCardTest(){
        List<AccountInfo> accountInfoList=new UserDaoImpl().findAccountNativeQueryByUser(userInfo);
        Assert.assertEquals(accountInfoList.size(),2);
        List<AccountInfo> accountInfoList2=new UserDaoImpl().findAccountNativeQueryByType("gas-Card");
        AccountInfo accountInfo = accountInfoList2.get(0);
        Assert.assertEquals(accountInfoList2.size(),1);
        //CreditCardInfo c2=new CreditCardInfo(2206L,"NEWBBC");
        //CreditCardInfo c3=new CreditCardInfo(2207L,"NEWCBC");
        //ArrayList<CreditCardInfo> cardList =new ArrayList();
        //cardList.add(c2);
        //cardList.add(c3);
        //new UserDaoImpl().updateAccount(accountInfo);
    }
    @BeforeSuite
    public void dropAllTablesTest(){
        TableDroperImpl droper = new TableDroperImpl();
        droper.dropAllTablesBeforeTest();
        userInfo=new UserServiceImpl().createNewUser("may","may-pass");
        AccountInfo newAccount = new UserServiceImpl().createNewAccount("Credit-Card", userInfo);
        AccountInfo newAccount2 = new UserServiceImpl().createNewAccount("gas-Card", userInfo);
        CreditCardInfo c1=new CreditCardInfo(2203L,"ABC");
        CreditCardInfo c2=new CreditCardInfo(2204L,"BBC");
        CreditCardInfo c3=new CreditCardInfo(2205L,"CBC");
        ArrayList<CreditCardInfo> cardList =new ArrayList();
        cardList.add(c1);
        cardList.add(c2);
        cardList.add(c3);
        newAccount.setCreditCardInfos(cardList);
        newAccount2.setCreditCardInfos(cardList);
        new UserDaoImpl().updateAccount(newAccount);
    }
}
