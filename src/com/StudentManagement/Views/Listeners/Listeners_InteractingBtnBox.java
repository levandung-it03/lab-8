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

    public static ActionListener insertStudentAction(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parentFrame.getActionType() != 0) {
                    JOptionPane.showMessageDialog(
                            parentFrame,
                            "You are updating student " + parentFrame.getInputBox().getStudentId() + " can not insert new!",
                            "Notice",
                            JOptionPane.PLAIN_MESSAGE
                    );
                    return;
                }

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

                    parentFrame.getListBox().getDefaultTableModel().addRow(new String[] {
                            validateRes.get("studentId"),
                            validateRes.get("lastName"),
                            validateRes.get("firstName"),
                            validateRes.get("gradeCode"),
                            validateRes.get("gradeName"),
                            validateRes.get("phone"),
                            validateRes.get("email")
                    });
                }
            }
        };
    }

    public static ActionListener searchStudentAction(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableRowSorter<DefaultTableModel> searchRowFilter =
                        new TableRowSorter<>(parentFrame.getListBox().getDefaultTableModel());
                parentFrame.getListBox().getTable().setRowSorter(searchRowFilter);
                List<RowFilter<Object,Object>> filters = new ArrayList<>(2);
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getStudentId().getText(), 0));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getLastName().getText(), 1));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getFirstName().getText(), 2));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getGradeCode().getText(), 3));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getGradeName().getText(), 4));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getPhone().getText(), 5));
                filters.add(RowFilter.regexFilter(parentFrame.getInputBox().getEmail().getText(), 6));
                searchRowFilter.setRowFilter(RowFilter.andFilter(filters));
            }
        };
    }

    public static ActionListener updateStudentAction(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentFrame.setActionType(1);

                int rowPointed = parentFrame.getListBox().getRowPointed();
                JTable table = parentFrame.getListBox().getTable();

                if (rowPointed == -1) {
                    JOptionPane.showMessageDialog(parentFrame, "Please choose the row you want to update!",
                            "Notice", JOptionPane.PLAIN_MESSAGE);
                    return;
                }

                parentFrame.getInputBox().getStudentId().setEnabled(false);

                String[] values = new String[table.getColumnCount()];
                for (int col = 0; col < values.length; col++)
                    values[col] = table.getValueAt(rowPointed, col).toString();

                parentFrame.getInputBox().getStudentId().setText(values[0]);
                parentFrame.getInputBox().getLastName().setText(values[1]);
                parentFrame.getInputBox().getFirstName().setText(values[2]);
                parentFrame.getInputBox().getGradeCode().setText(values[3]);
                parentFrame.getInputBox().getGradeName().setText(values[4]);
                parentFrame.getInputBox().getPhone().setText(values[5]);
                parentFrame.getInputBox().getEmail().setText(values[6]);
            }
        };
    }

    public static ActionListener saveUpdatingStudentAction(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parentFrame.getActionType() != 1)
                    return;

                HashMap<String, String> validateRes = Listeners_InputBox.validate(parentFrame);

                if (validateRes.get("result").equals("0")) {
                    JOptionPane.showMessageDialog(parentFrame, validateRes.get("message"), "Notice",
                            JOptionPane.PLAIN_MESSAGE);
                    return;
                }

                HashMap<String, String> updateRes = Controller_Student.updateStudent(validateRes);
                JOptionPane.showMessageDialog(parentFrame, updateRes.get("message"), "Notice", JOptionPane.PLAIN_MESSAGE);

                if (updateRes.get("result").equals("1")) {
                    parentFrame.getInputBox().getStudentId().setText("");
                    parentFrame.getInputBox().getStudentId().setEnabled(true);
                    parentFrame.getInputBox().getLastName().setText("");
                    parentFrame.getInputBox().getFirstName().setText("");
                    parentFrame.getInputBox().getGradeCode().setText("");
                    parentFrame.getInputBox().getGradeName().setText("");
                    parentFrame.getInputBox().getPhone().setText("");
                    parentFrame.getInputBox().getEmail().setText("");

                    parentFrame.getListBox().removeAll();
                    parentFrame.getListBox().createListBox();
                    parentFrame.getListBox().revalidate();
                    parentFrame.getListBox().repaint();
                    parentFrame.setActionType(0);
                }
            }
        };
    }

    public static ActionListener deleteStudentAction(Frame_Main parentFrame) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowPointed = parentFrame.getListBox().getRowPointed();
                JTable table = parentFrame.getListBox().getTable();

                if (rowPointed == -1) {
                    JOptionPane.showMessageDialog(parentFrame, "Please choose the row you want to delete!",
                            "Notice", JOptionPane.PLAIN_MESSAGE);
                    return;
                }

                String studentId = parentFrame.getListBox().getTable().getValueAt(rowPointed, 0).toString();


                HashMap<String, String> deletionRes = Controller_Student.deleteStudent(studentId);
                JOptionPane.showMessageDialog(parentFrame, deletionRes.get("message"), "Notice",
                        JOptionPane.PLAIN_MESSAGE);

                if (deletionRes.get("result").equals("1")) {
                    parentFrame.getListBox().removeAll();
                    parentFrame.getListBox().createListBox();
                    parentFrame.getListBox().validate();
                    parentFrame.getListBox().repaint();
                }
            }
        };
    }
}
