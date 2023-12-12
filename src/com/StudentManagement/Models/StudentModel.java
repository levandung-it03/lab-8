package com.StudentManagement.Models;

public class StudentModel {
    private final String studentId;
    private String lastName;
    private String firstName;
    private String gradeCode;
    private String gradeName;
    private String phone;
    private String email;

    // Constructor
    public StudentModel(String studentId, String lastName, String firstName, String gradeCode, String gradeName,
                        String phone, String email) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gradeCode = gradeCode;
        this.gradeName = gradeName;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public String getGradeCode() { return gradeCode; }
    public String getGradeName() { return gradeName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // Setters
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setGradeCode(String gradeCode) { this.gradeCode = gradeCode; }
    public void setGradeName(String gradeName) { this.gradeName = gradeName; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
}
