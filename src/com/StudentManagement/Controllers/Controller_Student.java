package com.StudentManagement.Controllers;

import com.StudentManagement.DataObjectModels.StudentDAO;
import com.StudentManagement.Models.StudentModel;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller_Student {
    public Controller_Student() {
        super();
    }

    public static String[][] getAllStudentWithTableFormat() {
        ArrayList<StudentModel> students = StudentDAO.getInstance().selectAll();

        if (students != null) {
            String[][] result = new String[students.size()][7];
            for (int i = 0; i < students.size(); i++) {
                result[i][0] = students.get(i).getStudentId();
                result[i][1] = students.get(i).getLastName();
                result[i][2] = students.get(i).getFirstName();
                result[i][3] = students.get(i).getGradeCode();
                result[i][4] = students.get(i).getGradeName();
                result[i][5] = students.get(i).getPhone();
                result[i][6] = students.get(i).getEmail();
            }
            return result;
        }

        return new String[][]{};
    }

    public static HashMap<String, String> insertStudent(HashMap<String, String> validateRes) {
        HashMap<String, String> result = new HashMap<>();
        StudentModel inputModel = new StudentModel(
                validateRes.get("studentId"),
                validateRes.get("lastName"),
                validateRes.get("firstName"),
                validateRes.get("gradeCode"),
                validateRes.get("gradeName"),
                validateRes.get("phone"),
                validateRes.get("email")
        );

        int insertRes = StudentDAO.getInstance().insert(inputModel);
        if (insertRes == 0) {
            result.put("result", "0");
            result.put("message", "Insert student failed!");
            return result;
        }

        if (insertRes == -1) {
            result.put("result", "0");
            result.put("message", "Student Id or Email is already existed!");
            return result;
        }

        if (insertRes == -2) {
            result.put("result", "0");
            result.put("message", "There is something wrong with your application!");
            return result;
        }

        result.put("result", "1");
        result.put("message", "Insert new student successfully!");
        return result;
    }

    //--------------------------------------------------------------
    public static HashMap<String, String> deleteStudent(String studentId) {
        HashMap<String, String> result = new HashMap<>();

        int deleteRes = StudentDAO.getInstance().delete(studentId);
        if (deleteRes == 0) {
            result.put("result", "0");
            result.put("message", "Can not delete Student Id");
            return result;
        }

        if (deleteRes == -2) {
            result.put("result", "0");
            result.put("message", "There is something wrong with your application!");
            return result;
        }

        result.put("result", "1");
        result.put("message", "Delete student successfully!");
        return result;
    }
//--------------------------------------------------------------------------------
        public static HashMap<String, String> updateStudent(HashMap<String, String> validateRes)    {
            HashMap<String, String> result = new HashMap<>();
            StudentModel inputModel = new StudentModel(
                    validateRes.get("studentId"),
                    validateRes.get("lastName"),
                    validateRes.get("firstName"),
                    validateRes.get("gradeCode"),
                    validateRes.get("gradeName"),
                    validateRes.get("phone"),
                    validateRes.get("email")
            );

            int updateRes = StudentDAO.getInstance().update(inputModel);
            if (updateRes == 0) {
                result.put("result", "0");
                result.put("message", "Can not update unknown Student Id");
                return result;
            }

            if (updateRes == -1) {
                result.put("result", "0");
                result.put("message", "Email is already existed!");
                return result;
            }

            if (updateRes == -2) {
                result.put("result", "0");
                result.put("message", "There is something wrong with your application!");
                return result;
            }

            result.put("result", "1");
            result.put("message", "Update student successfully!");
            return result;
        }
}
