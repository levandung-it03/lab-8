package com.StudentManagement.Views.Graphics;

import com.StudentManagement.Controllers.Controller_Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel_ListBox extends JPanel {
    private final Frame_Main parentFrame;
    private DefaultTableModel defaultTableModel;
    private JTable table;

    private int rowPointed = -1, columnPointed = -1;

    public Panel_ListBox(Frame_Main parentFrame) {
        super();
        this.parentFrame = parentFrame;
        this.createListBox();
        this.createListeners();
    }

    public void createListBox() {
        String[] columns = {"Mã SV", "Họ lót", "Tên", "Mã lớp", "Tên lớp", "Số ĐT", "Email"};
        String[][] values = Controller_Student.getAllStudentWithTableFormat();

        this.defaultTableModel = new DefaultTableModel(values, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.table = new JTable(defaultTableModel);

        this.table.getTableHeader().setReorderingAllowed(false);
        this.table.getTableHeader().setPreferredSize(new Dimension((int) (Frame_Main.fullAppWidth * 0.95), 27));
        this.table.getTableHeader().setBackground(new Color(203, 218, 255));
        this.table.getTableHeader().setFont(Frame_Main.font);

        this.table.setRowHeight(25);
        this.table.getColumnModel().getColumn(0).setPreferredWidth(32);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(85);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.table.getColumnModel().getColumn(3).setPreferredWidth(32);
        this.table.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.table.getColumnModel().getColumn(5).setPreferredWidth(32);
        this.table.getColumnModel().getColumn(6).setPreferredWidth(135);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension((int) (Frame_Main.fullAppWidth * 0.95), 300));

        this.add(scrollPane);
    }

    public void createListeners() {
        this.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                rowPointed = table.rowAtPoint(e.getPoint());
                columnPointed = table.columnAtPoint(e.getPoint());
                System.out.println(rowPointed + " " + columnPointed);
            }
        });
    }

    // Getters
    public JTable getTable() { return table; }
    public DefaultTableModel getDefaultTableModel() { return defaultTableModel; }
    public Frame_Main getParentFrame() { return parentFrame; }
    public int getRowPointed() { return rowPointed; }
    public int getColumnPointed() { return columnPointed; }
}
