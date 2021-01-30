package com.example.hibernate.utils;

import org.hibernate.SessionFactory;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.ParseException;
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



    public static Date getDateFormat(String stringFormatToDate) {

        // convert end return format date
        Date dateResult = null;


        try {
        SimpleDateFormat sDate = new SimpleDateFormat("dd/MM/yyyy");
            dateResult = sDate.parse(stringFormatToDate);
            } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateResult;
    }

}
