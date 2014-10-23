package userDomainNoSpring;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by twer on 14-10-6.
 */
public class UserDaoImpl implements UserDao {
    public AccountInfo saveAccount(AccountInfo accountInfo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(accountInfo);
        em.getTransaction().commit();
        emf.close();
        return accountInfo;
    }
    public AccountInfo updateAccount(AccountInfo accountInfo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(accountInfo);
        em.getTransaction().commit();
        emf.close();
        return accountInfo;
    }
    public List<AccountInfo> findAccountNativeQueryByUser(UserInfo userInfo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<AccountInfo> ret= (List<AccountInfo>) em.createNativeQuery("select * from accountinfo").getResultList();
        em.getTransaction().commit();
        emf.close();
        return ret;
    }

    public List<AccountInfo> findAccountNativeQueryByType(String acctype) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<AccountInfo> ret= em.createNativeQuery("select * from accountinfo where ACCOUNTTYPE =:acctype")
                .setParameter("acctype",acctype)
                .getResultList();
        em.getTransaction().commit();
        emf.close();
        return ret;
    }

    public UserInfo saveUser(UserInfo userInfo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(userInfo);
        em.getTransaction().commit();
        emf.close();
        return userInfo;
    }
    public UserInfo findUser(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UserInfo userInfo = em.find(UserInfo.class,id);
        em.getTransaction().commit();
        emf.close();
        return userInfo;
    }

    public void updateUser(UserInfo userInfo){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("zboUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(userInfo);
        em.getTransaction().commit();
        emf.close();
    }
}
