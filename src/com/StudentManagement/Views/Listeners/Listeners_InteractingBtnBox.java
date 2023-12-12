package com.StudentManagement.Views.Listeners;

import com.StudentManagement.Controllers.Controller_Student;
import com.StudentManagement.Views.Graphics.Frame_Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Listeners_InteractingBtnBox {
    public Listeners_InteractingBtnBox() { super(); }

    public static ActionListener insertStudent(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> validateRes = Listeners_InputBox.validate(parentFrame);

                if (validateRes.get("result").equals("0")) {
                    JOptionPane.showMessageDialog(parentFrame, validateRes.get("message"), "Notice",
                            JOptionPane.PLAIN_MESSAGE);
                    return;
                }

                HashMap<String, String> insertionRes = Controller_Student.insertStudent(validateRes);
                JOptionPane.showMessageDialog(parentFrame, insertionRes.get("message"), "Notice",
                        JOptionPane.PLAIN_MESSAGE);

                if (insertionRes.get("result").equals("1")) {
                    parentFrame.getInputBox().getStudentId().setText("");
                    parentFrame.getInputBox().getLastName().setText("");
                    parentFrame.getInputBox().getFirstName().setText("");
                    parentFrame.getInputBox().getGradeCode().setText("");
                    parentFrame.getInputBox().getGradeName().setText("");
                    parentFrame.getInputBox().getPhone().setText("");
                    parentFrame.getInputBox().getEmail().setText("");

                    parentFrame.getListBox().createListBox();
                }
            }
        };
    }

}
