package com.StudentManagement.Views.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GeneralComponents {
    public GeneralComponents() { super(); }
    public static JPanel generateInputTextPanel(String str, JTextField originInpTag, int formatType) {
        JPanel container = new JPanel(new BorderLayout());
        JLabel label = new JLabel(str);
        label.setPreferredSize(new Dimension(70, 30));
        label.setFont(Frame_Main.font);

        originInpTag.setFont(Frame_Main.font);

        container.add(label, BorderLayout.WEST);
        container.add(originInpTag, BorderLayout.CENTER);
        container.setBorder(new EmptyBorder(5, 5, 5, 5));
        container.setBackground(new Color(255, 204, 204));

        // Automatically Capitalize All Letters When Focus Lost.
        if (formatType == 1 || formatType == 0) {
            originInpTag.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String text = originInpTag.getText();
                    if (formatType == 1)    text = text.toUpperCase();
                    if (formatType == 0)    text = text.toLowerCase();

                    String result = this.removeAllWhiteSpace(text);
                    originInpTag.setText(result);
                }
                public String removeAllWhiteSpace(String text) {
                    return Arrays.stream(text.split(""))
                            .filter(letter -> !letter.equals(" "))
                            .collect(Collectors.joining(""));
                }
            });
        }

        // Automatically Capitalize All First Letters When Focus Lost.
        if (formatType == 2) {
            originInpTag.addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    String text = originInpTag.getText().trim();
                    String[] words = text.split(" ");
                    String result = Arrays.stream(words)
                            .filter(word -> !word.isEmpty())
                            .map(this::capitalizeFirstLetter)
                            .collect(Collectors.joining(" "));
                    originInpTag.setText(result);
                }

                public String capitalizeFirstLetter(String word) {
                    StringBuilder temp = new StringBuilder(word.toLowerCase());
                    temp.replace(0, 1, Character.toString(temp.charAt(0)).toUpperCase());
                    return temp.toString();
                }
            });
        }

        return container;
    }
    public static JButton generateInteractBtn(String str, String iconPath, int width) {
        JButton btn = new JButton(str, new ImageIcon(iconPath));
        btn.setPreferredSize(new Dimension(width, 50));
        btn.setFont(Frame_Main.font);
        return btn;
    }
}
