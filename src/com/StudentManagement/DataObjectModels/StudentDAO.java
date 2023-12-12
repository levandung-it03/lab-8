package com.StudentManagement.DataObjectModels;

import com.StudentManagement.Models.StudentModel;
import com.StudentManagement.DBConnection.DBInteraction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDAO {
    public StudentDAO() { super(); }

    public static StudentDAO getInstance() { return new StudentDAO(); }

    public int insert(StudentModel studentObj) {
        Connection myConnection = DBInteraction.startDBConnection();
        try {
            String query = "INSERT INTO Student VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = myConnection.prepareStatement(query);
            ps.setString(1, studentObj.getStudentId());
            ps.setString(2, studentObj.getLastName());
            ps.setString(3, studentObj.getFirstName());
            ps.setString(4, studentObj.getGradeCode());
            ps.setString(5, studentObj.getGradeName());
            ps.setString(6, studentObj.getPhone());
            ps.setString(7, studentObj.getEmail());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBInteraction.closeDBConnection(myConnection);
        }
        return -1;
    }

    public int update(StudentModel studentObj) {
        Connection myConnection = DBInteraction.startDBConnection();
        try {
            String query = "UPDATE Student SET last_name=?, first_name=?, grade_code=?, grade_name=?, phone=?," +
                    "email=? WHERE student_id=?";

            PreparedStatement ps = myConnection.prepareStatement(query);
            ps.setString(1, studentObj.getLastName());
            ps.setString(2, studentObj.getFirstName());
            ps.setString(3, studentObj.getGradeCode());
            ps.setString(4, studentObj.getGradeName());
            ps.setString(5, studentObj.getPhone());
            ps.setString(6, studentObj.getEmail());
            ps.setString(7, studentObj.getStudentId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBInteraction.closeDBConnection(myConnection);
        }
        return -1;
    }

    public int delete(String id) {
        Connection myConnection = DBInteraction.startDBConnection();
        try {
            PreparedStatement ps = myConnection.prepareStatement("DELETE FROM Student WHERE student_id=?");
            ps.setString(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBInteraction.closeDBConnection(myConnection);
        }
        return -1;
    }

    public StudentModel selectById(String id) {
        Connection myConnection = DBInteraction.startDBConnection();
        try {
            PreparedStatement ps = myConnection.prepareStatement("SELECT * FROM Student WHERE student_id=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new StudentModel(
                        rs.getString("student_id"), rs.getString("last_name"),
                        rs.getString("first_name"), rs.getString("grade_code"),
                        rs.getString("grade_name"), rs.getString("phone"),
                        rs.getString("email")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBInteraction.closeDBConnection(myConnection);
        }
        return null;
    }

    public ArrayList<StudentModel> selectAll() {
        Connection myConnection = DBInteraction.startDBConnection();
        try {
            PreparedStatement ps = myConnection.prepareStatement("SELECT * FROM Student");
            ResultSet rs = ps.executeQuery();
            ArrayList<StudentModel> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new StudentModel(
                        rs.getString("student_id"), rs.getString("last_name"),
                        rs.getString("first_name"), rs.getString("grade_code"),
                        rs.getString("grade_name"), rs.getString("phone"),
                        rs.getString("email")
                ));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBInteraction.closeDBConnection(myConnection);
        }
        return null;
    }

    public ArrayList<StudentModel> selectByCondition(String condition) {
        Connection myConnection = DBInteraction.startDBConnection();
        try {
            PreparedStatement ps = myConnection.prepareStatement("SELECT * FROM Student " + condition);
            ResultSet rs = ps.executeQuery();
            ArrayList<StudentModel> result = new ArrayList<>();
            while (rs.next()) {
                result.add(new StudentModel(
                        rs.getString("student_id"), rs.getString("last_name"),
                        rs.getString("first_name"), rs.getString("grade_code"),
                        rs.getString("grade_name"), rs.getString("phone"),
                        rs.getString("email")
                ));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBInteraction.closeDBConnection(myConnection);
        }
        return null;
    }
}
