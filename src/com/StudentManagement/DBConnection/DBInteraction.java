package com.StudentManagement.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

public class DBInteraction {
    public DBInteraction() { super(); }

    public static Connection startDBConnection() {
        Connection myConnection = null;
        final String dbURL = "jdbc:mysql://localhost:3306/";
        final String dbName = "Student_Management";
        final String username = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            myConnection = DriverManager.getConnection(dbURL + dbName, username, password);

        } catch (SQLException e) {
            myConnection = DBInitialization.initializeDB(dbURL, dbName, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("Failed To Connect To DB!");
            e.printStackTrace();
        }

        return myConnection;
    }

    public static void closeDBConnection(Connection myConnection) {
        try {
            if (myConnection != null) {
                myConnection.close();
            }
        } catch (SQLException e) {
            System.out.println("Close DB Failed!");
            e.printStackTrace();
        }
    }
}
