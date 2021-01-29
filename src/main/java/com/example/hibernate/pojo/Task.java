package com.example.hibernate.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tasks_new_table")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//sequence//auto//table//
    private int id;

    @Column(name = "task_name")
    private String taskName;

    private int priority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Owner owner;

    public Task() {
    }

    public Task(int id, String taskName, int priority, Owner owner) {
        this.id = id;
        this.taskName = taskName;
        this.priority = priority;
        this.owner = owner;
    }

    public Task(String taskName, int priority, Owner owner) {
        this.taskName = taskName;
        this.priority = priority;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", owner=" + owner +
                '}';
    }
}
