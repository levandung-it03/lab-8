package com.StudentManagement.Views.Listeners;

import com.StudentManagement.Views.Graphics.Frame_Main;

import java.util.HashMap;
import java.util.regex.Pattern;

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

        if (result.get("studentId").isEmpty()) {
            result.put("result", "0");
            result.put("message", "Invalid value at Student Id");
            return result;
        }

        if (!Pattern
                .compile("^N[0-9]{2}([A-Z]{4}|[A-Z]{6})[0-9]{3}$")
                .matcher( result.get("studentId") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at Student Id");
            return result;
        }

        if (!Pattern
                .compile("^[A-Z][a-z]*(\\s[A-Z]+[a-z]*)*$")
                .matcher( result.get("lastName") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at Last Name");
            return result;
        }

        if (!Pattern
                .compile("^[A-Z][a-z]*$")
                .matcher( result.get("firstName") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at First Name");
            return result;
        }

        if (!Pattern
                .compile("^[DE]{1}[0-9]{2}([A-Z]{4}|[A-Z]{6})[0-9]{2}-N$")
                .matcher( result.get("gradeCode") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at Grade Code");
            return result;
        }

        if (!Pattern
                .compile("^[\\w\\d\\s-() ]+$")
                .matcher( result.get("gradeName") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at Grade Name");
            return result;
        }

        if (!Pattern
                .compile("^[0]{1}[\\d]{9,10}$")
                .matcher( result.get("phone") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at Phone");
            return result;
        }

        if (!Pattern
                .compile("^n[\\d]{2}([\\w]{4}|[\\w]{6})[\\d]{3}@student.ptithcm.edu.vn$")
                .matcher( result.get("email") )
                .matches()
        ) {
            result.put("result", "0");
            result.put("message", "Invalid value at Email");
            return result;
        }

        result.put("result", "1");
        return result;
    }
}
