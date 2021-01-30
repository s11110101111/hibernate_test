package com.example.hibernate.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("dept_id")
    private int departmentId;
    @Column("dept_name")
    private String departmentName;
    @Column("dept_location")
    private String departmentLocation;


}
