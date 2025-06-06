package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {
    
    public HibernateTemplate hibernateTemplate;
    

    // Setter for dependency injection
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    //Save Student
    @Transactional
    public int insert(Student student)
    {
        //  Insert/read
        int i=(int)this.hibernateTemplate.save(student);
        return i;
    }
    
    
    //get the single data(object)
    public Student detStudent(int studentId)
    {
       Student s =this.hibernateTemplate.get(Student.class, studentId);
       return s;
    }
    
    //get the multiple data(object)
    public List<Student> getAllStudent()
    {
       List<Student> s=this.hibernateTemplate.loadAll(Student.class);
        return s;
    }
    
    //deleting the data
    @Transactional
    public void deleteStudent(int studentId)
    {
        Student s=this.hibernateTemplate.get(Student.class, studentId);
        this.hibernateTemplate.delete(s); 
    }
    
    //updating data
    @Transactional
    public void updateStudent(Student student)
    {
        this.hibernateTemplate.update(student);
    }

    public Student getStudent(int sid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
} 
