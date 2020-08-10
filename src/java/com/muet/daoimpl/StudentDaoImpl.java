/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.StudentDao;
import com.muet.model.Department;
import com.muet.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    ResultSet rst=null;
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
         //To change body of generated methods, choose Tools | Templates.
         con=DBConnection.getConnection();
        try {
            pst=con.prepareStatement("update student set full_name=?,roll_number=?,fathers_name=?,legal_id=?,legal_id_no=?,nationality=?,place_of_issue_of_legal_id=?,date_of_issue_of_legal_id=?,mobile=?,dob=?,email=?,"
                    + "domicile=?,country_of_birth=?,blood_group=?,religion=?,address=?,current_address=?,semester=?,batch=?,admission_date=?,program=?,field_program=?,shift=?,timing=? where student_id=?");
            pst.setString(1,student.getFullName());
            pst.setString(2,student.getRollNumber());
            pst.setString(3,student.getFathersName());
            pst.setString(4,student.getLegalId());
            pst.setString(5,student.getLegalIdNo());
            pst.setString(6,student.getNationality());
            pst.setString(7,student.getPlaceOfIssueOfLegalId());
            pst.setString(8,student.getDateOfIssueOfLegalId());
            pst.setString(9,student.getMobile());
            pst.setString(10,student.getDob());
            pst.setString(11,student.getEmail());
            pst.setString(12,student.getDomicile());
            pst.setString(13,student.getCountryOfBirth());
            pst.setString(14,student.getBloodGroup());
            pst.setString(15,student.getReligion());
            pst.setString(16,student.getAddress());
            pst.setString(17,student.getCurrentAddress());
            pst.setInt(18,student.getSemester());
            pst.setInt(19,student.getBatch());
            pst.setString(20,student.getAdmissionDate());
            pst.setString(21,student.getProgram());
            pst.setString(22,student.getFieldProgram());
            pst.setString(23,student.getShift());
            pst.setString(24,student.getTiming());
            pst.setInt(25,student.getStudentId());
            

            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean deleteStudent(Integer id) {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("delete from student where student_id = ?");
            pst.setInt(1, id);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Student> getStudentById(Integer id) {
         //To change body of generated methods, choose Tools | Templates.
         con=DBConnection.getConnection();
         List<Student> std = new ArrayList<>();
         Department department =new Department();
         
        try {
            pst=con.prepareStatement("select * from student where student_id =?");
            pst.setInt(1, id);
            rst=pst.executeQuery();
            while(rst.next()){
                Student student =new Student();
                student.setStudentId(rst.getInt("student_id"));
                student.setFullName(rst.getString("full_name"));
                student.setRollNumber(rst.getString("roll_number"));
                student.setFathersName(rst.getString("fathers_name"));
                student.setLegalId(rst.getString("legal_id"));
                student.setLegalIdNo(rst.getString("legal_id_no"));
                student.setNationality(rst.getString("nationality"));
                student.setPlaceOfIssueOfLegalId(rst.getString("place_of_issue_of_legal_id"));
                student.setDateOfIssueOfLegalId(rst.getString("date_of_issue_of_legal_id"));
                student.setMobile(rst.getString("mobile"));
                student.setDob(rst.getString("dob"));
                student.setEmail(rst.getString("email"));
                student.setDomicile(rst.getString("domicile"));
                student.setCountryOfBirth(rst.getString("country_of_birth"));
                student.setBloodGroup(rst.getString("blood_group"));
                student.setReligion(rst.getString("religion"));
                student.setAddress(rst.getString("address"));
                student.setCurrentAddress(rst.getString("current_address"));
                student.setSemester(rst.getInt("semester"));
              //  student.setDepartmentId(rst.getInt("department_id"));
                student.setBatch(rst.getInt("batch"));
                student.setAdmissionDate(rst.getString("admission_date"));
               // student.setSupervisorId(rst.getInt("supervisor_id"));
                student.setProgram(rst.getString("program"));
                student.setFieldProgram(rst.getString("field_program"));
                student.setShift(rst.getString("shift"));
                student.setTiming(rst.getString("timing"));
                std.add(student);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return std;
        
    }

    @Override
    public List<Student> getStudents() {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        List<Student> std = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("select * from student");
            rst = pst.executeQuery();
            while ( rst.next() ) {
               Student student = new Student();
                student.setStudentId(rst.getInt("student_id"));
                student.setFullName(rst.getString("full_name"));
                student.setRollNumber(rst.getString("roll_number"));
                std.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return std;
    }

    @Override
    public Student getStudentByStudentName(String studentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
