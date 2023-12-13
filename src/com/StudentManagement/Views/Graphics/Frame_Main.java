package com.StudentManagement.Views.Graphics;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;

public class Frame_Main extends JFrame {
    public static int fullAppWidth = 900;
    public static int fullAppHeight = 700;
    public static Font font = new Font("Consolas", Font.PLAIN, 15);

    private final String title;
    private Panel_HeaderBox headerBox;
    private Panel_InputBox inputBox;
    private Panel_InteractingBtnBox interactingBtnBox;
    private Panel_ListBox listBox;

    private int actionType = 0;

    public Frame_Main(String title) {
        super();
        this.title = title;
        this.createMainFrame();
    }

    public void createMainFrame() {
        UIManager.put("Label.font", Frame_Main.font);

        this.setTitle(this.title);
        this.setLayout(new FlowLayout());
        this.setSize(fullAppWidth, fullAppHeight);

        this.headerBox = new Panel_HeaderBox();
        this.inputBox = new Panel_InputBox(this);
        this.interactingBtnBox = new Panel_InteractingBtnBox(this);
        this.listBox = new Panel_ListBox(this);

        add(headerBox);
        add(inputBox);
        add(interactingBtnBox);
        add(listBox);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public Panel_HeaderBox getHeaderBox() { return this.headerBox; }
    public Panel_InputBox getInputBox() { return this.inputBox; }
    public Panel_ListBox interactingBtnBox() { return this.listBox; }
    public Panel_ListBox getListBox() { return this.listBox; }
    public Panel_InteractingBtnBox getInteractingBtnBox() { return interactingBtnBox; }

    public void setActionType(int actionType) { this.actionType = actionType; }
    public int getActionType() { return actionType; }
}
