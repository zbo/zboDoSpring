package userDomainNoSpring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by twer on 14-10-7.
 */
public class TableDroperImpl {
    public void dropAllTablesBeforeTest(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("drop table ACCOUNTINFO").executeUpdate();
        em.createNativeQuery("drop table USERINFO").executeUpdate();
        em.createNativeQuery("drop table CREDITCARDINFO").executeUpdate();
        em.createNativeQuery("drop table ACCOUNTINFO_CREDITCARDINFO").executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
}
