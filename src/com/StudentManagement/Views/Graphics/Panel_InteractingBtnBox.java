package com.StudentManagement.Views.Graphics;

import com.StudentManagement.Views.Listeners.Listeners_InteractingBtnBox;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;

public class Panel_InteractingBtnBox extends JPanel {
    private final Frame_Main parentFrame;
    private final String mainPath = "src/com/StudentManagement/Assets";
    private final JButton searchBtn = GeneralComponents.generateInteractBtn(" Tìm ",
            mainPath + "/Icons/Search.png", (int) (Frame_Main.fullAppWidth * 0.3));
    private final JButton insertBtn = GeneralComponents.generateInteractBtn(" Thêm ",
            mainPath + "/Icons/Add.png", (int) (Frame_Main.fullAppWidth * 0.05));
    private final JButton saveBtn = GeneralComponents.generateInteractBtn(" Lưu ",
            mainPath + "/Icons/Save.png", (int) (Frame_Main.fullAppWidth * 0.05));
    private final JButton updateBtn = GeneralComponents.generateInteractBtn(" Sửa ",
            mainPath + "/Icons/Update.png", (int) (Frame_Main.fullAppWidth * 0.3));
    private final JButton deleteBtn = GeneralComponents.generateInteractBtn(" Xoá ",
            mainPath + "/Icons/Delete.png", (int) (Frame_Main.fullAppWidth * 0.05));

    public Panel_InteractingBtnBox(Frame_Main parentFrame) {
        super();
        this.parentFrame = parentFrame;
        this.createInteractingBtnBox();
        this.createListeners();
    }

    public void createInteractingBtnBox() {
        this.setLayout(new GridLayout(1, 5, 10, 10));
        this.setPreferredSize(new Dimension((int) (Frame_Main.fullAppWidth * 0.95), 50));

        this.add(searchBtn);
        this.add(insertBtn);
        this.add(saveBtn);
        this.add(updateBtn);
        this.add(deleteBtn);
    }

    public void createListeners() {
        insertBtn.addActionListener(Listeners_InteractingBtnBox.insertStudentAction(this.parentFrame));
        updateBtn.addActionListener(Listeners_InteractingBtnBox.updateStudentAction(this.parentFrame));
        saveBtn.addActionListener(Listeners_InteractingBtnBox.saveUpdatingStudentAction(this.parentFrame));
        deleteBtn.addActionListener(Listeners_InteractingBtnBox.deleteStudentAction(this.parentFrame));
        searchBtn.addActionListener(Listeners_InteractingBtnBox.searchStudentAction(this.parentFrame));
    }

    public Frame_Main getParentFrame() {
        return parentFrame;
    }
}
