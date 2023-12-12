package com.StudentManagement.Controllers;

import com.StudentManagement.DataObjectModels.StudentDAO;
import com.StudentManagement.Models.StudentModel;
import java.util.ArrayList;

public class Controller_Student {
    public Controller_Student() { super(); }

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

        return new String[][] {};
    }
}
