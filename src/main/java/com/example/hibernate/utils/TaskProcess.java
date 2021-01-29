package com.example.hibernate.utils;

import org.hibernate.SessionFactory;

public class TaskProcess {

    private SessionFactory sessionFactory;

    public TaskProcess() {
        sessionFactory = HibernateUtils.getSessionFactory();
     }


}
