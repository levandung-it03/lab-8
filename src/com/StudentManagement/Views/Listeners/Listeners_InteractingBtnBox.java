package com.StudentManagement.Views.Listeners;

import com.StudentManagement.Controllers.Controller_Student;
import com.StudentManagement.Views.Graphics.Frame_Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

                    parentFrame.getListBox().removeAll();
                    parentFrame.getListBox().createListBox();
                    parentFrame.getListBox().validate();
                    parentFrame.getListBox().repaint();
                }
            }
        };
    }
    public static ActionListener searchStudent(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel searchObj = (DefaultTableModel) parentFrame.getListBox().getTable().getModel();
                TableRowSorter<DefaultTableModel> searchObj1 = new TableRowSorter<>(searchObj);
                parentFrame.getListBox().getTable().setRowSorter(searchObj1);
                List<RowFilter<Object,Object>> filters = new ArrayList<>(2);
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getStudentId().getText(), 0));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getLastName().getText(), 1));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getFirstName().getText(), 2));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getGradeCode().getText(), 3));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getGradeName().getText(), 4));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getPhone().getText(), 5));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getEmail().getText(), 6));
                searchObj1.setRowFilter(RowFilter.andFilter(filters));
            }
        };
    }

}
