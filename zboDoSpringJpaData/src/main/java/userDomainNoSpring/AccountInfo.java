package userDomainNoSpring;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by twer on 14-10-6.
 */
@Entity
public class AccountInfo implements Serializable {
    @OneToOne
    private UserInfo Userinfo;

    @OneToMany(cascade=CascadeType.PERSIST)
    private List<CreditCardInfo> CreditCardInfos;

    private String AccountType;

    public AccountInfo() {
    }

    @Id
    @GeneratedValue
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserInfo getUserinfo() {
        return Userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        Userinfo = userinfo;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public List<CreditCardInfo> getCreditCardInfos() {
        return CreditCardInfos;
    }

    public void setCreditCardInfos(List<CreditCardInfo> creditCardInfos) {
        CreditCardInfos = creditCardInfos;
    }
}
