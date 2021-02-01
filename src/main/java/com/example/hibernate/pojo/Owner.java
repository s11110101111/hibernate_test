package com.example.hibernate.pojo;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owner_table")
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "owner_name")
    private String name;

    @OneToMany(mappedBy = "owner")//  field  in Task.class
   // @LazyCollection(LazyCollectionOption.EXTRA)//толко для упорядочных коллекций
   // @OrderColumn(name = "owner_index") // Index necessary to know which element to lazy-init!
    private Set<Task> tasks = new HashSet<>();;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        tasks.forEach(f-> sb.append("[task name= ")
                .append(f.getTaskName())
                .append(" priority ")
                .append(f.getPriority())
                .append("]"));
        sb.append("}");

        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "Tasks " + sb +
                '}';
    }
}
