package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException err) {
            System.out.println("Error while loading driver : " + err.getMessage());
        }

        try {
            String url = "jdbc:postgresql://localhost:5432/demo";
            String uname = "postgres";
            String password = "password";
            String sqlQuery = "INSERT INTO students (id, sname, marks) VALUES (?, ?, ?)";

            Connection connection = DriverManager.getConnection(url, uname, password);

            PreparedStatement pStatement = connection.prepareStatement(sqlQuery);

            pStatement.setInt(1, 1002);
            pStatement.setString(2, "Mohit");
            pStatement.setInt(3, 60);

            pStatement.execute();

            connection.close();
        } catch (SQLException err) {
            System.out.println("Error while creating connection : " + err.getMessage());
        }
    }
}