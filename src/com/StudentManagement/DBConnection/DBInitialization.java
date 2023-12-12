package com.StudentManagement.DBConnection;

import java.sql.*;

public class DBInitialization {
    public DBInitialization() { super(); }

    public static Connection initializeDB(String dbURL, String dbName, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            int result = DriverManager
                    .getConnection(dbURL, username, password)
                    .prepareStatement("CREATE DATABASE Student_Management;")
                    .executeUpdate();

            if (result != 0) {
                String query = """
                    CREATE TABLE Student (
                    \tstudent_id VARCHAR(20) UNIQUE NOT NULL,
                    \tlast_name VARCHAR(100) NOT NULL,
                    \tfirst_name VARCHAR(50) NOT NULL,
                    \tgrade_code VARCHAR(20) NOT NULL,
                    \tgrade_name VARCHAR(100) NOT NULL,
                    \tphone VARCHAR(20) NOT NULL,
                    \temail VARCHAR(30) UNIQUE NOT NULL,
                    \tCONSTRAINT PK_Student PRIMARY KEY (student_id),
                    \tCONSTRAINT UK_student_id_grade_code UNIQUE (student_id, grade_code)
                    );
                    INSERT INTO Student (student_id, last_name, first_name, grade_code, grade_name, phone, email)
                    VALUES
                    \t('N21DCCN021', 'Le Van', 'Dung', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863928', 'levandung.it03@gmail.com'),
                    \t('N21DCCN001', 'Nguyen Van', 'A', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863930', 'nguyenvana.2003@gmail.com'),
                    \t('N21DCCN002', 'Le Van', 'B', 'D21CQCN01-N', 'Cong Nghe Thong Tin 01', '0377863950', 'levanb.2003@gmail.com');""";

                Connection myConnection = DriverManager.getConnection(dbURL + dbName, username, password);
                PreparedStatement ps = myConnection.prepareStatement(query);
                if (ps.executeUpdate() != 0)
                    return myConnection;
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
