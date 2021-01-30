package com.example.hibernate.client;

import com.example.hibernate.entities.Department;
import com.example.hibernate.entities.Employee;
import com.example.hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class NamedQueryTest {
    public static void main(String[] args) {
        // SetDataClientToTestDB.initDb();
        //getEmployeeById(2);
      //  getTotalSalaryOfEmployeeByDept(0D);
        getDepartmentById(1);
    }

    public static void getEmployeeById(int emplId) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // get named query from annotation declared in class
            Query<Employee> query = session.getNamedQuery("Employee.byId");
            query.setParameter("byId", emplId);
            Employee employee = query.uniqueResult();
            System.out.println(employee);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null)
                session.close();
        }

    }

    public static void getDepartmentById(int byId) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
       // Query<Department> query = session.getNamedQuery("Department.byId");
            Query<Department> query = session.getNamedQuery("getDept.byId");
        query.setParameter("byId",byId);
        Department dept = query.uniqueResult();
            System.out.println(dept);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public static void getTotalSalaryOfEmployeeByDept(Double bySum) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Query<Object[]> query = session.getNamedQuery("getTotalSalaryOfEmployeeByDept");
            query.setParameter("bySum", bySum);
            List<Object[]> list = query.list();
            for (Object[] object : list) {
                String departmentName = (String) object[0];
                Double totalSalary = (Double) object[1];
                System.out.println("Department = " + departmentName);
                System.out.println("Total sum salary = " + totalSalary);
            }


        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }


    }
}