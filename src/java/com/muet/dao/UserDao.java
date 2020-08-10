/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.dao;

import com.muet.model.User;

/**
 *
 * @author khatr
 */
public interface UserDao {
    public User login(String email, String password);
}
