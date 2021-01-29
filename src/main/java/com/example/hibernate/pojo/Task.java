package com.example.hibernate.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name = "tasks_new_table")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sequence//auto//table//
    private int id;

    @Column(name = "task_name")
    private String taskName ;

    private int priority;

    private Owner owner;

}
