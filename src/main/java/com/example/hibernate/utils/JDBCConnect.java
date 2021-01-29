package com.example.hibernate.utils;

import com.example.hibernate.pojo.TaskClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCConnect {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        getAll();
    }

    private static void getAll() {
        String sql = "select * from tasks_table";
        List<TaskClass> tasks = new ArrayList<>();

        try {
            Connection cn = getConnection();
            Statement query = cn.createStatement();
            ResultSet rs = query.executeQuery(sql);

            while (rs.next()) {
                TaskClass task = new TaskClass();
                task.setId(rs.getInt("id"));
                task.setTaskName(rs.getString("task_name"));
                task.setOwner(rs.getString("owner"));
                task.setPriority(rs.getInt("priority"));
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        tasks.forEach(System.out::println);

    }

    // get connection load properties connection
    private static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(is);
        }
        String url = properties.getProperty("url");
        String userName = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, userName, password);
    }
}
