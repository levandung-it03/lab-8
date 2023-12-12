package com.StudentManagement.Views.Listeners;

import com.StudentManagement.Views.Graphics.Frame_Main;

import java.util.HashMap;

public class Listeners_InputBox {
    public Listeners_InputBox() { super(); }

    public static HashMap<String, String> validate(Frame_Main parentFrame) {
        HashMap<String, String> result = new HashMap<>();
        result.put("studentId", parentFrame.getInputBox().getStudentId().getText());
        result.put("lastName", parentFrame.getInputBox().getLastName().getText());
        result.put("firstName", parentFrame.getInputBox().getFirstName().getText());
        result.put("gradeCode", parentFrame.getInputBox().getGradeCode().getText());
        result.put("gradeName", parentFrame.getInputBox().getGradeName().getText());
        result.put("phone", parentFrame.getInputBox().getPhone().getText());
        result.put("email", parentFrame.getInputBox().getEmail().getText());



        return result;
    }
}
