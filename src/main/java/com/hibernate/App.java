package com.hibernate;

import java.util.List;

import com.hibernate.dao.StudentDao;
import com.hibernate.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       StudentDao studentDao = new StudentDao();
       
       Student student1 = new Student("Abdullah", "abdullah@gmail.com");
       studentDao.saveStudent(student1);
       
       Student student2 = new Student("Ismail", "ismail@gmail.com");
       studentDao.saveStudent(student2);
       
       List<Student> students = studentDao.getAllStudent();
       students.forEach(student3 -> System.out.println(student3.getId()));
    }
}
