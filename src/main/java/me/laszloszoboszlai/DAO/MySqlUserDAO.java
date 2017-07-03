package me.laszloszoboszlai.DAO;

import me.laszloszoboszlai.Entity.Role;
import me.laszloszoboszlai.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

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
               return newSession.createQuery("from User").list();
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

    }
}
