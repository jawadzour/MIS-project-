/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.SeminarDao;
import com.muet.dao.SeminarGroupDao;
import com.muet.dao.ThesisDao;
import com.muet.model.Seminar;
import com.muet.model.SeminarGroup;
import com.muet.model.Thesis;
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
public class SeminarGroupDaoImpl implements SeminarGroupDao {

    private PreparedStatement pst;
    private ResultSet rst;
    private Connection con;

    @Override
    public Boolean updateSeminarGroup(SeminarGroup seminarGroup) {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        SeminarDao seminarDao = new SeminarDaoImpl();
        Seminar seminar = new Seminar();
        seminar.setSeminarId(seminarGroup.getSeminar().getSeminarId());
        seminar.setSeminarTitle(seminarGroup.getSeminar().getSeminarTitle());
        seminarDao.updateSeminar(seminar);
        
        Thesis thesis =new Thesis();
        ThesisDao thesisDao=new ThesisDaoImpl();
        thesis.setThesisId(seminarGroup.getThesis().getThesisId());
        thesis.setThesisTitle(seminarGroup.getThesis().getThesisTitle());
        thesisDao.updateThesis(thesis);
        try {
            pst = con.prepareStatement("update seminar_thesis set seminar_id = ?,date_applied=?,date_conducted=?,remarks=?,comments=?, status=? ,thesis_id=? where seminar_group_id = ?");
            pst.setInt(1, seminarGroup.getSeminar().getSeminarId());
            pst.setString(2, seminarGroup.getDateApplied());
            pst.setString(3, seminarGroup.getDateConducted());
            pst.setString(4, seminarGroup.getRemarks());
            pst.setString(5, seminarGroup.getComments());
            pst.setString(6, seminarGroup.getStatus());
            pst.setInt(7,seminarGroup.getThesis().getThesisId());
            pst.setInt(8, seminarGroup.getSeminarGroupId());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean deleteSeminarGroup(Integer id) {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("delete from seminar_thesis where seminar_group_id = ?");
            pst.setInt(1, id);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public SeminarGroup getSeminarGroupById(Integer id) {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        SeminarGroup seminarGroup = new SeminarGroup();
        try {
            pst = con.prepareStatement("select * from seminar_thesis where seminar_group_id = ?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                Seminar seminar = new Seminar();
                SeminarDao seminarDao = new SeminarDaoImpl();
                Thesis thesis=new Thesis();
                ThesisDao thesisDao=new ThesisDaoImpl();
                seminarGroup.setSeminarGroupId(rst.getInt("seminar_group_id"));
                seminarGroup.setDateApplied(rst.getString("date_applied"));
                seminarGroup.setDateConducted(rst.getString("date_conducted"));
                seminarGroup.setRemarks(rst.getString("remarks"));
                seminarGroup.setComments(rst.getString("comments"));
                seminarGroup.setStatus(rst.getString("status"));
                seminar = seminarDao.getSeminarById(rst.getInt("seminar_id"));
                seminarGroup.setSeminar(seminar);
                thesis=thesisDao.getThesisById(rst.getInt("thesis_id"));
                seminarGroup.setThesis(thesis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seminarGroup;
    }

    @Override
    public List<SeminarGroup> getSeminarGroups() {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        List<SeminarGroup> seminarGroups = new ArrayList<>();
        try {
            pst = con.prepareStatement("select * from seminar_thesis;");
            rst = pst.executeQuery();
            while (rst.next()) {
                SeminarGroup seminarGroup = new SeminarGroup();
                SeminarDao seminarDao = new SeminarDaoImpl();
                ThesisDao thesisDao=new ThesisDaoImpl();
                seminarGroup.setSeminarGroupId(rst.getInt("seminar_group_id"));
                seminarGroup.setDateApplied(rst.getDate("date_applied").toString());
                seminarGroup.setDateConducted(rst.getDate("date_conducted").toString());
                seminarGroup.setRemarks(rst.getString("remarks"));
                seminarGroup.setComments(rst.getString("comments"));
                seminarGroup.setStatus(rst.getString("status"));
                Seminar seminar = seminarDao.getSeminarById(rst.getInt("seminar_id"));
                seminarGroup.setSeminar(seminar);
                Thesis thesis=thesisDao.getThesisById(rst.getInt("thesis_id"));
                seminarGroup.setThesis(thesis);
                seminarGroups.add(seminarGroup);
                System.out.println("Seminar List is working");
            }
            System.out.println(seminarGroups.size());
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seminarGroups;
    }

    @Override
    public List<SeminarGroup> getSeminarGroupsByStudentId(Integer id) {
        con = DBConnection.getConnection();
        List<SeminarGroup> seminarGroups = new ArrayList<>();
        try {
            pst = con.prepareStatement("SELECT * FROM seminar_thesis st JOIN thesis t ON t.`thesis_id` = st.`thesis_id` JOIN student s ON s.`student_id` = t.`student_id` WHERE s.`student_id` = ?;");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                SeminarGroup seminarGroup = new SeminarGroup();
                SeminarDao seminarDao = new SeminarDaoImpl();
                ThesisDao thesisDao=new ThesisDaoImpl();
                seminarGroup.setSeminarGroupId(rst.getInt("seminar_group_id"));
                seminarGroup.setDateApplied(rst.getDate("date_applied").toString());
                seminarGroup.setDateConducted(rst.getDate("date_conducted").toString());
                seminarGroup.setRemarks(rst.getString("remarks"));
                seminarGroup.setComments(rst.getString("comments"));
                seminarGroup.setStatus(rst.getString("status"));
                Seminar seminar = seminarDao.getSeminarById(rst.getInt("seminar_id"));
                seminarGroup.setSeminar(seminar);
                Thesis thesis=thesisDao.getThesisById(rst.getInt("thesis_id"));
                seminarGroup.setThesis(thesis);
                seminarGroups.add(seminarGroup);
                System.out.println("Seminar List is working");
            }
            System.out.println(seminarGroups.size());
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seminarGroups;
    }

}
