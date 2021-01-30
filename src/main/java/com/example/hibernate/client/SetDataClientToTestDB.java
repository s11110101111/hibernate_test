package com.example.hibernate.client;

import com.example.hibernate.entities.Department;
import com.example.hibernate.entities.Employee;
import com.example.hibernate.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

import static com.example.hibernate.utils.HibernateUtils.getDateFormat;

public class SetDataClientToTestDB {
    public static void main(String[] args) {

        SessionFactory sf= HibernateUtils.getSessionFactory();
        initDb(sf);

    }

    private static void initDb(SessionFactory sf) {
        Session session = null;
        try {
           session = sf.openSession();
           // open transaction
           session.beginTransaction();
            Employee employee1 = new Employee();
            employee1.setEmployeeName("Ivanov");
            employee1.setBonus(new BigDecimal(500));
            employee1.setSalary(80000.00);
            employee1.setEmail("asa@gmail.com");
            employee1.setDateOfJoin(getDateFormat("28/01/2000"));
            Employee employee2 = new Employee();
            employee2.setEmployeeName("Petrov");
            employee2.setBonus(new BigDecimal(300));
            employee2.setSalary(60000.00);
            employee2.setEmail("petrov@gmail.com");
            employee2.setDateOfJoin(getDateFormat("20/12/2001"));

            Department dept = new Department();
            dept.setDepartmentName("IT Technology1");
            dept.setDepartmentLocation("USA");
            dept.getEmployees().add(employee1);
            dept.getEmployees().add(employee2);

            employee1.setDepartment(dept);
            employee2.setDepartment(dept);
            session.save(dept);

            Employee employee3 = new Employee();
            employee3.setEmployeeName("Ashot");
            employee3.setBonus(new BigDecimal(100));
            employee3.setSalary(50000.00);
            employee3.setEmail("aa@gmail.com");
            employee3.setDateOfJoin(getDateFormat("21/12/1970"));

            Employee employee4 = new Employee();
            employee4.setEmployeeName("Smith");
            employee4.setBonus(new BigDecimal(600));
            employee4.setSalary(82000.00);
            employee4.setEmail("john@gmail.com");
            employee4.setDateOfJoin(getDateFormat("01/02/2001"));
            Employee employee6 = new Employee();
            employee6.setEmployeeName("Trump");
            employee6.setBonus(new BigDecimal(600));
            employee6.setSalary(90000.00);
            employee6.setEmail("donald@gmail.com");
            employee6.setDateOfJoin(getDateFormat("14/06/1946"));

            Employee employee5 = new Employee();
            employee5.setEmployeeName("Kalashnikov");
            employee5.setBonus(new BigDecimal(100));
            employee5.setSalary(10000.00);
            employee5.setEmail("ak-47@gmail.com");
            employee5.setDateOfJoin(getDateFormat("14/06/1941"));

            Department dept1 = new Department();
            dept1.setDepartmentName("IT Technology 2");
            dept1.setDepartmentLocation("Vietnam");
            dept1.getEmployees().add(employee3);
            dept1.getEmployees().add(employee4);
            dept1.getEmployees().add(employee5);
            dept1.getEmployees().add(employee6);

            employee3.setDepartment(dept1);
            employee4.setDepartment(dept1);
            employee5.setDepartment(dept1);
            employee6.setDepartment(dept1);

            session.save(dept1);


           // commit transaction
           session.getTransaction().commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            if (session != null) session.close();

        }
    }


}
