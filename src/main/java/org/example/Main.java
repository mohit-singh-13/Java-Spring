package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // import package - Done Above ✅

        // load and register (optional now, required before) ✅
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException err) {
            System.out.println("Error while loading driver : " + err.getMessage());
        }

        try {
            String url = "jdbc:postgresql://localhost:5432/demo";
            String uname = "postgres";
            String password = "password";
            // String sqlQuery = "SELECT sname FROM students WHERE id = 1";
            String sqlQuery = "SELECT * FROM students";

            // create connection ✅
            Connection connection = DriverManager.getConnection(url, uname, password);

            System.out.println("Connection established");

            // create statement ✅
            Statement statement = connection.createStatement();

            // execute statement ✅
            ResultSet result = statement.executeQuery(sqlQuery);

            // process the results ✅
            // result.next();
            // String name = result.getString("sname");

            // System.out.println("Name of the student is " + name);

            while (result.next()) {
                System.out.print(result.getInt(1) + " - ");
                System.out.print(result.getString(2) + " - ");
                System.out.println(result.getInt(3));
            }

            // close the connection ✅
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException err) {
            System.out.println("Error while creating connection : " + err.getMessage());
        }
    }
}