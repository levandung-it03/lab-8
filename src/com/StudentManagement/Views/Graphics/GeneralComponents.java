package com.StudentManagement.Views.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GeneralComponents {
    public GeneralComponents() { super(); }
    public static JPanel generateInputTextPanel(String str, JTextField originInpTag) {
        JPanel container = new JPanel(new BorderLayout());
        JLabel label = new JLabel(str);
        label.setPreferredSize(new Dimension(70, 30));
        label.setFont(Frame_Main.font);

        originInpTag.setFont(Frame_Main.font);

        container.add(label, BorderLayout.WEST);
        container.add(originInpTag, BorderLayout.CENTER);
        container.setBorder(new EmptyBorder(5, 5, 5, 5));
        container.setBackground(new Color(255, 204, 204));
        return container;
    }
    public static JButton generateInteractBtn(String str, String iconPath, int width) {
        JButton btn = new JButton(str, new ImageIcon(iconPath));
        btn.setPreferredSize(new Dimension(width, 50));
        btn.setFont(Frame_Main.font);
        return btn;
    }
}
