package com.example.hibernate.client;

import com.example.hibernate.entities.Employee;
import com.example.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class NamedQueryTest {
    public static void main(String[] args) {
       // SetDataClientToTestDB.initDb();
        getEmployeeById(2);

    }

public static void getEmployeeById(int emplId){
    Session session = HibernateUtils.getSessionFactory().openSession();
    // get named query from annotation declared in class
    Query<Employee> query = session.getNamedQuery("Employee.byId");
            query.setParameter("byId",emplId);
    Employee employee = query.uniqueResult();
    System.out.println(employee);

}
public static void getDepartmenById(){

}


}
