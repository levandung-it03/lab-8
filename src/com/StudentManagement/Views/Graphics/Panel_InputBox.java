package com.StudentManagement.Views.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class Panel_InputBox extends JPanel {
    private final Frame_Main parentFrame;

    private final JTextField studentId = new JTextField();
    private final JTextField lastName = new JTextField();
    private final JTextField firstName = new JTextField();
    private final JTextField gradeCode = new JTextField();
    private final JTextField gradeName = new JTextField();
    private final JTextField phone = new JTextField();
    private final JTextField email = new JTextField();
    
    public Panel_InputBox(Frame_Main parentFrame) {
        super();
        this.parentFrame = parentFrame;
        this.createInputBox();
        this.createListeners();
    }

    public void createInputBox() {
        int fullWidth = (int) (Frame_Main.fullAppWidth * 0.9);
        int fullHeight = 160;
        this.setBorder(new EmptyBorder(20, 40, 20, 40));
        this.setBackground(new Color(255, 204, 204));

        JPanel leftContainer = new JPanel(new GridLayout(4, 0));
        leftContainer.add(GeneralComponents.generateInputTextPanel("Mã SV:", this.studentId, 1));
        leftContainer.add(GeneralComponents.generateInputTextPanel("Họ lót:", this.lastName, 2));
        leftContainer.add(GeneralComponents.generateInputTextPanel("Mã lớp:", this.gradeCode, 1));
        leftContainer.add(GeneralComponents.generateInputTextPanel("Số ĐT:", this.phone, 1));

        JPanel rightContainer = new JPanel(new GridLayout(4, 0));
        JPanel empty = new JPanel();
        empty.setBackground(new Color(255, 204, 204));
        rightContainer.add(empty);
        rightContainer.add(GeneralComponents.generateInputTextPanel("Tên:", this.firstName, 2));
        rightContainer.add(GeneralComponents.generateInputTextPanel("Tên lớp:", this.gradeName, 2));
        rightContainer.add(GeneralComponents.generateInputTextPanel("Email:", this.email, 0));

        leftContainer.setPreferredSize(new Dimension((int) (fullWidth * 0.6), fullHeight));
        rightContainer.setPreferredSize(new Dimension((int) (fullWidth * 0.4), fullHeight));

        this.add(leftContainer, BorderLayout.WEST);
        this.add(rightContainer, BorderLayout.EAST);
    }

    public void createListeners() {
        parentFrame.getInputBox().getStudentId().setText("");
        parentFrame.getInputBox().getLastName().setText("");
        parentFrame.getInputBox().getFirstName().setText("");
        parentFrame.getInputBox().getGradeCode().setText("");
        parentFrame.getInputBox().getGradeName().setText("");
        parentFrame.getInputBox().getPhone().setText("");
        parentFrame.getInputBox().getEmail().setText("");
    }

    public Frame_Main getParentFrame() { return parentFrame; }
    public JTextField getStudentId() { return studentId; }
    public JTextField getLastName() { return lastName; }
    public JTextField getFirstName() { return firstName; }
    public JTextField getGradeCode() { return gradeCode; }
    public JTextField getGradeName() { return gradeName; }
    public JTextField getPhone() { return phone; }
    public JTextField getEmail() { return email; }
}
