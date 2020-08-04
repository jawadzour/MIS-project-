/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.FeesDao;
import com.muet.model.Fees;
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
 * @author khatr
 */
public class FeesDaoImpl implements FeesDao{
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rst;
    public FeesDaoImpl() {
        con = DBConnection.getConnection();
    }

    @Override
    public Boolean addFees(Fees fees) {
        
        try {
            pst = con.prepareStatement("insert into fees (fees_title, amount, announcement_date, due_date) values (?, ?, ?, ?);");
            pst.setString(1, fees.getFeesTitle());
            pst.setInt(2, fees.getAmount());
            pst.setTimestamp(3, fees.getAnnouncementDate());
            pst.setTimestamp(4, fees.getDueDate());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FeesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean updateFees(Fees fees) {
        
        try {
            pst = con.prepareStatement("update fees set fees_title = ?, amount = ?, announcement_date = ?, due_date = ? where fees_id = ?");
            pst.setString(1, fees.getFeesTitle());
            pst.setInt(2, fees.getAmount());
            pst.setTimestamp(3, fees.getAnnouncementDate());
            pst.setTimestamp(4, fees.getDueDate());
            pst.setInt(5, fees.getFeesId());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FeesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean deleteFees(Integer id) {
        
        try {
            pst = con.prepareStatement("delete from fees where fees_id = ?");
            pst.setInt(1, id);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FeesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Fees getFeesById(Integer id) {
        Fees fees = new Fees();
        try {
            pst = con.prepareStatement("select * from fees where fees_id = ?;");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                fees.setFeesId(rst.getInt("fees_id"));
                fees.setFeesTitle(rst.getString("fees_title"));
                fees.setAmount(rst.getInt("amount"));
                fees.setAnnouncementDate(rst.getTimestamp("announcement_date"));
                fees.setDueDate(rst.getTimestamp("due_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fees;
    }

    @Override
    public List<Fees> getFees() {
        List<Fees> feeses = new ArrayList<>();
        try {
            pst = con.prepareStatement("select * from fees;");
            rst = pst.executeQuery();
            while (rst.next()) {
                Fees fees = new Fees();
                fees.setFeesId(rst.getInt("fees_id"));
                fees.setFeesTitle(rst.getString("fees_title"));
                fees.setAmount(rst.getInt("amount"));
                fees.setAnnouncementDate(rst.getTimestamp("announcement_date"));
                fees.setDueDate(rst.getTimestamp("due_date"));
                feeses.add(fees);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return feeses;
    }
    
}
