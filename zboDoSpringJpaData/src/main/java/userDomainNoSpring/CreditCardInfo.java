package userDomainNoSpring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CreditCardInfo {
    private String id;
    private Long CardNum;
    private String BankName;

    public CreditCardInfo() {
    }

    public CreditCardInfo(Long cardNum, String bankName) {
        CardNum = cardNum;
        BankName = bankName;
    }

    @Id@GeneratedValue
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCardNum() {
        return CardNum;
    }

    public void setCardNum(Long cardNum) {
        CardNum = cardNum;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }
}
