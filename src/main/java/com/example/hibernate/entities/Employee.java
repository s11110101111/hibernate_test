package com.example.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "employee_name", length = 70, nullable = false)
    private String employeeName;
    @Column(name = "employee_date_ofjoin")
    private Date dateOfJoin;
    @Column(name = "employee_salary")
    private Double salary;
    @Column(name = "employee_bonus")
    private BigDecimal bonus;
    @Column(name = "employee_email",length = 50,nullable = false,unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date employeeDateOfJoin) {
        this.dateOfJoin = employeeDateOfJoin;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeDateOfJoin=" + dateOfJoin +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}
