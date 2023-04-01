/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author randah
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
             // loads configuration and mappings
             Configuration configuration = new Configuration().configure("/project00/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
             configuration.addAnnotatedClass(UserP.class);
             configuration.addAnnotatedClass(CV.class);
             configuration.addAnnotatedClass(education.class);
             configuration.addAnnotatedClass(goal.class);
             configuration.addAnnotatedClass(languages.class);
             configuration.addAnnotatedClass(experience.class);
             configuration.addAnnotatedClass(skill.class);
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}