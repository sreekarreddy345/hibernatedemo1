package com.sreekar.hibernate.pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private long studentId;
    private String studentName;
    private float marks;

    public Student() {
    }

    public Student(long studentId) {
        this.studentId = studentId;
    }

    public Student(long studentId, String studentName, float marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public Student(String studentName, float marks) {
        this.studentName = studentName;
        this.marks = marks;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public float getMarks() {
        return marks;
    }

    public void setMarks(float marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", marks=" + marks +
                '}';
    }
}
