package me.laszloszoboszlai.playground;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory createSessionFactory() {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                 configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static void main(String[] args) {
      /*
        // create session factory:
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create a session
        */

        SessionFactory factory = createSessionFactory();

        Session session = factory.getCurrentSession();
        //use session to save a Java object
        try{
            //start transaction
            session.beginTransaction();

            //query students using HQL
            List<Student> theStudents = session.createQuery("from Student s where s.lastName='Dylan' or "
                    +" s.firstName='Axel' and s.email LIKE '%yahoo.com'").list();

            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally{
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student aStudent : theStudents){
            System.out.println(aStudent);
        }
    }

}