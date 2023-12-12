package com.StudentManagement.Views.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Panel_HeaderBox extends JPanel {
    public Panel_HeaderBox() {
        super();
        this.createHeaderBox();
    }

    public void createHeaderBox() {
        this.setLayout(new FlowLayout());
        this.setBackground(new Color(204, 255, 204));
        this.setPreferredSize(new Dimension(Frame_Main.fullAppWidth, 55));

        JLabel title = new JLabel("QUẢN LÝ SINH VIÊN");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 30.0f));
        title.setBorder(new EmptyBorder(10, 0, 0, 0));

        this.add(title);
    }
}
