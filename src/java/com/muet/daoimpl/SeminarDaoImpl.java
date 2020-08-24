/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.SeminarDao;
import com.muet.model.Seminar;
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
public class SeminarDaoImpl implements SeminarDao{

    private PreparedStatement pst;
    private ResultSet rst;
    private Connection con;

    @Override
    public Boolean addSeminar(Seminar seminar) {
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("insert into seminar (seminar_title) values (?)");
            pst.setString(1, seminar.getSeminarTitle());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false ;
    }

    @Override
    public Boolean updateSeminar(Seminar seminar) {
       //To change body of generated methods, choose Tools | Templates.
       con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("update seminar set seminar_title = ? where seminar_id = ?");
            pst.setString(1, seminar.getSeminarTitle());
            pst.setInt(2, seminar.getSeminarId());
            System.out.println("Seminar Dao Impl title "+seminar.getSeminarTitle());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean deleteSeminar(Integer id) {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        try {
            pst = con.prepareStatement("delete from seminar where seminar_id = ?");
            pst.setInt(1, id);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Seminar getSeminarById(Integer id) {
         //To change body of generated methods, choose Tools | Templates.
         con = DBConnection.getConnection();
        Seminar seminar = new Seminar();
        try {
            pst = con.prepareStatement("select * from seminar where seminar_id = ?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while ( rst.next() ) {
                seminar.setSeminarId(rst.getInt("seminar_id"));
                seminar.setSeminarTitle(rst.getString("seminar_title"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seminar;
    }

    @Override
    public List<Seminar> getSeminars() {
        //To change body of generated methods, choose Tools | Templates.
        con = DBConnection.getConnection();
        List<Seminar> seminars = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("select * from seminar");
            rst = pst.executeQuery();
            while ( rst.next() ) {
                Seminar seminar = new Seminar();
                seminar.setSeminarId(rst.getInt("seminar_id"));
                seminar.setSeminarTitle(rst.getString("seminar_title"));
                seminars.add(seminar);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seminars;
    }

    @Override
    public Seminar getSeminarBySeminarName(String seminarTitle) {
        //To change body of generated methods, choose Tools | Templates.
         con = DBConnection.getConnection();
        Seminar seminar = new Seminar();
        try {
            pst = con.prepareStatement("select * from seminar where seminar_title = ?");
            pst.setString(1, seminarTitle);
            rst = pst.executeQuery();
            while ( rst.next() ) {
                seminar.setSeminarId(rst.getInt("seminar_id"));
                seminar.setSeminarTitle(rst.getString("seminar_title"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return seminar;
    }
}
    

