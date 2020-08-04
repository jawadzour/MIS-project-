/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.StudentDao;
import com.muet.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 92310
 */
public class StudentDaoImpl implements StudentDao {
    Connection con=null;
    PreparedStatement pst=null;
    int t=0;
    @Override
    public Integer  addStudent(Student student) {
         //To change body of generated methods, choose Tools | Templates.
          con=DBConnection.getConnection();
         
        try {
            System.out.println(student.getFullName());
            pst=con.prepareStatement("insert into student(full_name,roll_number) values(?,?)");
            pst.setString(1,student.getFullName());
            pst.setString(2,student.getRollNumber());
            t=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
             
             
         return t;
    }

    @Override
    public Boolean updateStudent(Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getFacultyById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getFaculties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getFacultyByFacultyName(String studentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
