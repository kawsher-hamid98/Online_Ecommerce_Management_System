//package com.onlineApp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class App {
//    @Autowired
//    private static JdbcTemplate jdbcTemplate;
//
//
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb2", "root", "root1234");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from user");
//
//        resultSet.next();
//        String string = resultSet.getString("name");
//        String email = resultSet.getString("email");
//
//        System.out.println(string);
//        System.out.println(email);
//    }
//}