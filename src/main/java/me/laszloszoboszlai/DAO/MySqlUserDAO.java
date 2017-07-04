package me.laszloszoboszlai.DAO;

import me.laszloszoboszlai.Entity.Role;
import me.laszloszoboszlai.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;

/**
 * Created by laci on 02/07/2017.
 */

@Repository
@Qualifier("mySqlData")
public class MySqlUserDAO implements UserDAO{

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory createSessionFactory() {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    SessionFactory session = createSessionFactory();

    @Override
    public Collection<User> getAllUsers() {
        Session newSession = session.getCurrentSession();
                newSession.beginTransaction();

                List<User> users = newSession.createQuery("from User").list();
               return users;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User getUserByCredentials(String email, String password) {
        return null;
    }

    @Override
    public void updateUserBy(User user) {

    }

    @Override
    public void registerUser(User user) {
        Session newSession = session.getCurrentSession();
        newSession.beginTransaction();
        newSession.save(user);
        session.getCurrentSession().close();
    }



    @Override
    public User findUserByName(String userName) {
        Session newSession = session.getCurrentSession();
        newSession.beginTransaction();
        String hql = "FROM User u WHERE u.userName = :uname";
        Query query = newSession.createQuery(hql);
        query.setParameter("uname",userName);
        User theUser = (User)query.getSingleResult();
        return theUser;
    }

    @Override
    public boolean isUserExists(User user) {
        String email = user.getEmail();
        String userName = user.getUserName();

        try {
            Session newSession = session.getCurrentSession();
            newSession.beginTransaction();
            String hql = "FROM User u WHERE u.userName = :uname OR u.email = :email";
            Query query = newSession.createQuery(hql);
            query.setParameter("uname", userName);
            query.setParameter("email", email);

            User theUser = (User) query.getSingleResult();

        } catch (NoResultException exception){
            return false;
        }
        finally {
            session.getCurrentSession().close();
        }
        return true;
    }
}
