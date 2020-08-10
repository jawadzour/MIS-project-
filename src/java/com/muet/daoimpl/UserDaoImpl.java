/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.daoimpl;

import com.muet.connection.DBConnection;
import com.muet.dao.UserDao;
import com.muet.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khatr
 */
public class UserDaoImpl implements UserDao{
    private final Connection con;
    private PreparedStatement pst;
    private ResultSet rst;
    public UserDaoImpl() {
        con = DBConnection.getConnection();
    }
    @Override
    public User login(String email, String password) {
        User user = new User();
        try {
            pst = con.prepareStatement("select * from users where email = ? and password = ?;");
            pst.setString(1, email);
            pst.setString(2, password);
            rst= pst.executeQuery();
            while (rst.next()) {
                user.setUserId(rst.getInt("user_id"));
                user.setFullName(rst.getString("full_name"));
                user.setEmail(rst.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
}
