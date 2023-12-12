package com.StudentManagement.DBConnection;

import java.sql.*;

public class DBInitialization {
    public DBInitialization() { super(); }

    public static Connection initializeDB(String dbURL, String dbName, String username, String password) {
        try {
            try (PreparedStatement ps = DriverManager
                    .getConnection(dbURL, username, password)
                    .prepareStatement("CREATE DATABASE IF NOT EXISTS " + dbName)) {
                ps.executeUpdate();
            }

            Connection myConnection = DriverManager.getConnection(dbURL + dbName, username, password);

            initializeStudentTable(myConnection);

            return myConnection;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void initializeStudentTable(Connection myConnection) {
        try {
            try (PreparedStatement ps = myConnection.prepareStatement("USE Student_Management;")) {
                ps.execute();
            }

            try (PreparedStatement ps = myConnection.prepareStatement("""
                    CREATE TABLE IF NOT EXISTS Student (
                        student_id VARCHAR(20) UNIQUE NOT NULL,
                        last_name VARCHAR(100) NOT NULL,
                        first_name VARCHAR(50) NOT NULL,
                        grade_code VARCHAR(20) NOT NULL,
                        grade_name VARCHAR(100) NOT NULL,
                        phone VARCHAR(20) NOT NULL,
                        email VARCHAR(30) UNIQUE NOT NULL,
                        CONSTRAINT PK_Student PRIMARY KEY (student_id),
                        CONSTRAINT UK_student_id_grade_code UNIQUE (student_id, grade_code)
                    );""")
            ) {
                ps.execute();
            }

            try (PreparedStatement ps = myConnection.prepareStatement("""
                    INSERT INTO Student (student_id, last_name, first_name, grade_code, grade_name, phone, email) VALUES
                    ('N21DCCN021', 'Le Van', 'Dung', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863928', 'levandung.it03@gmail.com'),
                    ('N21DCCN001', 'Nguyen Van', 'A', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863930', 'nguyenvana.2003@gmail.com'),
                    ('N21DCCN002', 'Le Van', 'B', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863950', 'levanb.2003@gmail.com');
                    """)
            ) {
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
