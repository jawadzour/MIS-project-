/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.StudentDao;
import com.muet.model.Thesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.muet.dao.ThesisDao;
import com.muet.model.Student;

/**
 *
 * @author khatr
 */
public class ThesisDaoImpl implements ThesisDao{
    
    private final Connection con;
    private PreparedStatement pst;
    private ResultSet rst;
    
    public ThesisDaoImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public Boolean addThesis(Thesis thesis) {
        
        try {
            pst = con.prepareStatement("insert into thesis (thesis_title, student_id, thesis_exam_date, final_results, remarks) values (?, ?, ?, ?, ?);");
            pst.setString(1, thesis.getThesisTitle());
            pst.setInt(2, thesis.getStudent().getStudentId());
            pst.setString(3, thesis.getThesisExamDate());
            pst.setInt(4, thesis.getFinalResults());
            pst.setString(5, thesis.getRemarks());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThesisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Boolean updateThesis(Thesis thesis) {
        try {
            pst = con.prepareStatement("update thesis set thesis_title = ?, thesis_exam_date = ?, final_results = ?, remarks = ?, student_id = ? where thesis_id = ?");
            pst.setString(1, thesis.getThesisTitle());
            pst.setString(2, thesis.getThesisExamDate());
            pst.setInt(3, thesis.getFinalResults());
            pst.setString(4, thesis.getRemarks());
            pst.setInt(5, thesis.getStudent().getStudentId());
            pst.setInt(6, thesis.getThesisId());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThesisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Boolean DeleteThesis(Integer id) {
        try {
            pst = con.prepareStatement("delete from thesis where thesis_id = ?");
            pst.setInt(1, id);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ThesisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Thesis getThesisById(Integer id) {
        Thesis thesis = new Thesis();
        try {
            pst = con.prepareStatement("select * from thesis where thesis_id = ?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                StudentDao studentDao = new StudentDaoImpl();
                Student student = studentDao.getStudentById(rst.getInt("student_id"));
                thesis.setStudent(student);
                thesis.setThesisTitle(rst.getString("thesis_title"));
                thesis.setThesisExamDate(rst.getString("thesis_exam_date"));
                thesis.setThesisId(rst.getInt("thesis_id"));
                thesis.setFinalResults(rst.getInt("final_results"));
                thesis.setRemarks(rst.getString("remarks"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThesisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return thesis;
    }

    @Override
    public List<Thesis> getTheses() {
        List<Thesis> theses = new ArrayList<>();
        try {
            pst = con.prepareStatement("select * from thesis;");
            rst = pst.executeQuery();
            while (rst.next()) {
                Thesis thesis = new Thesis();
                Student student = new Student();
                student.setStudentId(rst.getInt("student_id"));
                thesis.setStudent(student);
                thesis.setThesisTitle(rst.getString("thesis_title"));
                thesis.setThesisExamDate(rst.getString("thesis_exam_date"));
                thesis.setThesisId(rst.getInt("thesis_id"));
                thesis.setFinalResults(rst.getInt("final_results"));
                thesis.setRemarks(rst.getString("remarks"));
                theses.add(thesis);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThesisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return theses;
    }
    
}
