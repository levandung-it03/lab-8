package com.StudentManagement.Views.Listeners;

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
                String[] values = new String[] {
                        parentFrame.getInputBox().getStudentId(),
                        parentFrame.getInputBox().get(),
                        parentFrame.getInputBox().getStudentId(),
                        parentFrame.getInputBox().getStudentId(),
                        parentFrame.getInputBox().getStudentId(),
                        parentFrame.getInputBox().getStudentId()
                };
                HashMap<String, String> validateRes = Listeners_InputBox.validate();

                if (validateRes.get("result").equals("0")) {
                    JOptionPane.showMessageDialog(parentFrame, validateRes.get("message"), "Notice",
                            JOptionPane.PLAIN_MESSAGE);
                    return;
                }


            }
        };
    }

}
