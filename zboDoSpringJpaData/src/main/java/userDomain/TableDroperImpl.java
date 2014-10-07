package userDomain;

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
        em.createNativeQuery("drop table accountinfo").executeUpdate();
        em.createNativeQuery("drop table userinfo").executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
}
