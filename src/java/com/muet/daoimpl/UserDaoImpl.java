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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khatr
 */
public class UserDaoImpl implements UserDao {

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
            rst = pst.executeQuery();
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

    @Override
    public Boolean addUser(User user) {
        try {
            pst = con.prepareStatement("insert into users (full_name, email, password) values (?,?,?);");
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean updateUser(User user) {
        try {
            pst = con.prepareStatement("update users set full_name = ?, email = ?, password = ? where user_id = ?;");
            pst.setString(1, user.getFullName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setInt(4, user.getUserId());
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        try {
            pst = con.prepareStatement("delete from users where user_id = ?;");
            pst.setInt(1, id);
            return pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        try {
            pst = con.prepareStatement("select * from users where user_id = ?");
            pst.setInt(1, id);
            rst = pst.executeQuery();
            while (rst.next()) {
                user.setFullName(rst.getString("full_name"));
                user.setUserId(rst.getInt("user_id"));
                user.setEmail(rst.getString("email"));
                user.setPassword(rst.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            pst = con.prepareStatement("select * from users;");
            rst = pst.executeQuery();
            while (rst.next()) {
                User user = new User();
                user.setFullName(rst.getString("full_name"));
                user.setUserId(rst.getInt("user_id"));
                user.setEmail(rst.getString("email"));
                user.setPassword(rst.getString("password"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

}
