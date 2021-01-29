package com.example.hibernate.utils;

import com.example.hibernate.pojo.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TaskProcess {

    private SessionFactory sessionFactory;

    public TaskProcess() {
        sessionFactory = HibernateUtils.getSessionFactory();
    }

    //get all
    public List<Task> getAll() {
        // get criteria query
        Session session = sessionFactory.openSession();
        session.get(Task.class, 0);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Task.class);

        Root<Task> root = cq.from(Task.class);
        cq.select(root);

        Query query = session.createQuery(cq);

        List<Task> tasks = query.getResultList();


        return null;
    }

}
