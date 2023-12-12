package com.StudentManagement.Views.Graphics;

import com.StudentManagement.Controllers.Controller_Student;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Panel_ListBox extends JPanel {
    private final Frame_Main parentFrame;
    private DefaultTableModel defaultTableModel;
    private JTable table;
    private String[][] tableData;

    public Panel_ListBox(Frame_Main parentFrame) {
        super();
        this.parentFrame = parentFrame;
        this.createListBox();
        this.saveCurrentTableData();
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
//        this.table.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                super.keyReleased(e);
//            }
//        });
//
//        this.table.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int clickedRow = table.rowAtPoint(e.getPoint());
//                int clickedColumn = table.columnAtPoint(e.getPoint());
//
//                if (clickedColumn == 0)
//                    JOptionPane.showMessageDialog(getParentFrame(), "You Can't Update Student Id!");
//
//                if (clickedColumn == 3)
//                    JOptionPane.showMessageDialog(getParentFrame(), "You Can't Update Grade Code!");
//
//                if (clickedColumn == 4)
//                    JOptionPane.showMessageDialog(getParentFrame(), "You Can't Update Grade Name!");
//            }
//        });
    }

    public void saveCurrentTableData() {
        this.tableData = new String[this.table.getRowCount()][table.getColumnCount()];
        for (int row = 0; row < this.table.getRowCount(); row++)
            for (int column = 0; column < this.table.getColumnCount(); column++)
                this.tableData[row][column] = this.table.getValueAt(row, column).toString();
    }

    // Getters
    public JTable getTable() { return table; }
    public DefaultTableModel getDefaultTableModel() { return defaultTableModel; }
    public Frame_Main getParentFrame() { return parentFrame; }
    public String[][] getTableData() { return tableData; }
}
