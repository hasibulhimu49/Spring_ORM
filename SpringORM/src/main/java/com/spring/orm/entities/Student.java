package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Student_details")
public class Student {
    
    
    @Id
    @Column(name="s_id")
    private int studentId;
    @Column(name="s_name")
    private String studentName;
    @Column(name="s_city")
    private String studentCity;

    public Student(int studentId, String studentName, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }
    
    
    
    
    
}
