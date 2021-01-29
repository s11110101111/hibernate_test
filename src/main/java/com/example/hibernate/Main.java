package com.example.hibernate;

import com.example.hibernate.utils.TaskProcess;

public class Main {
    public static void main(String[] args) {
        TaskProcess tp = new TaskProcess();
        tp.getAll().forEach(System.out::println);

    }
}
