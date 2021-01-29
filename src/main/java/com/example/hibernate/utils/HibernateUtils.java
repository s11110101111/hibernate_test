package com.example.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.service.internal.StandardSessionFactoryServiceInitiators;

public class HibernateUtils {
// begin with SessionFactory
SessionFactory sessionFactory;
static {
    //create static init factory
    final StandardServiceRegistry registry = new StandardServiceRegistryImpl();
}


public SessionFactory getSessionFactory(){
    return sessionFactory;
}

}
