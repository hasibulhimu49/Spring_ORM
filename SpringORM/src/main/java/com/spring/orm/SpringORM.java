package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringORM {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean go = true;

        while (go) {
            System.out.println("\n==== Student Management Application ====");
            System.out.println("PRESS 1 to Add New Student");
            System.out.println("PRESS 2 to Display All Students");
            System.out.println("PRESS 3 to Get Details of Single Student");
            System.out.println("PRESS 4 to Delete Student");
            System.out.println("PRESS 5 to Update Student");
            System.out.println("PRESS 6 to Exit");
            System.out.print("Enter your choice: ");

            try {
                int input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 1:
                        // Add Student
                        System.out.print("Enter student ID: ");
                        int id = Integer.parseInt(br.readLine());

                        System.out.print("Enter student name: ");
                        String name = br.readLine();

                        System.out.print("Enter student city: ");
                        String city = br.readLine();

                        Student s = new Student(id, name, city);
                        int result = studentDao.insert(s);
                        System.out.println("Student added with ID: " + result);
                        break;

                    case 2:
                        // Display All Students
                        List<Student> allStudents = studentDao.getAllStudent();
                        for (Student st : allStudents) {
                            System.out.println("ID: " + st.getStudentId());
                            System.out.println("Name: " + st.getStudentName());
                            System.out.println("City: " + st.getStudentCity());
                            System.out.println("--------------------------");
                        }
                        break;

                    case 3:
                        // Get Single Student
                        System.out.print("Enter student ID: ");
                        int sid = Integer.parseInt(br.readLine());
                        Student student = studentDao.getStudent(sid);
                        if (student != null) {
                            System.out.println("ID: " + student.getStudentId());
                            System.out.println("Name: " + student.getStudentName());
                            System.out.println("City: " + student.getStudentCity());
                        } else {
                            System.out.println("Student not found with ID: " + sid);
                        }
                        break;

                    case 4:
                        // Delete Student
                        System.out.print("Enter student ID to delete: ");
                        int did = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(did);
                        System.out.println("Deleted student with ID: " + did);
                        break;

                    case 5:
                        // Update Student
                        System.out.print("Enter student ID to update: ");
                        int uid = Integer.parseInt(br.readLine());

                        System.out.print("Enter new name: ");
                        String uname = br.readLine();

                        System.out.print("Enter new city: ");
                        String ucity = br.readLine();

                        Student us = new Student(uid, uname, ucity);
                        studentDao.updateStudent(us);
                        System.out.println("Student updated.");
                        break;

                    case 6:
                        // Exit
                        go = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Try again.");
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nThank you for using the application.");
        System.out.println("See you soon!");
    }
}
