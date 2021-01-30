package com.example.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.service.internal.StandardSessionFactoryServiceInitiators;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HibernateUtils {
    // begin with SessionFactory
    private static SessionFactory sessionFactory;

    static {
        //create static init factory
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }


    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }



    public static Date getDateFormat(String stringFormatDate) {

        // convert end return format date
        Date dateResult = null;

        try {
            SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yyyy");

            dateResult = getDateFormat(stringFormatDate);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateResult;
    }

}
