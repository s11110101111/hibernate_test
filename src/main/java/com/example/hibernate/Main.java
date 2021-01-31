package com.example.hibernate;

import com.example.hibernate.pojo.Owner;
import com.example.hibernate.pojo.Task;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner();
        owner.setName("KUKU");
        insertOwner(owner);
        Owner owner1 = new Owner();
        owner1.setName("AAAAAAAAAAAA");
        insertOwner(owner1);
        Owner owner2 = new Owner();
        owner2.setName("111111-KUKU");
        insertOwner(owner2);

        Task task = new Task();
        task.setTaskName("GOO");
        task.setPriority(Priority.MEDIUM);
        task.setCreatedDate(LocalDateTime.now());
        task.setOwner(owner);
            insertTask(task);
        Task task1 = new Task();
        task1.setTaskName("come on GOO");
        task1.setCreatedDate(LocalDateTime.now());
        task1.setPriority(Priority.HIGHEST);
        task1.setOwner(owner);
        insertTask(task1);

        System.out.println(getOwner(1));
    }
private static Owner getOwner(int byId){
        Session session =openSession();
        Owner owner = (Owner)session.get(Owner.class,byId);
    Hibernate.initialize(owner.getTasks());
    session.close();
        return owner;
}
    private static void insertOwner(Owner owner) {
        Session session = openSession();
        session.getTransaction().begin();
        session.persist(owner);
        session.getTransaction().commit();
    }

    private static void insertTask(Task task) {
        Session session = openSession();
        session.getTransaction().begin();
        session.persist(task);
        session.getTransaction().commit();
    }

    private static SessionFactory sessionFactory = null;

    private static Session openSession() {
        if (sessionFactory == null) {
            final Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Owner.class);
            configuration.addAnnotatedClass(Task.class);

            sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
        }
        return sessionFactory.openSession();
    }
}
