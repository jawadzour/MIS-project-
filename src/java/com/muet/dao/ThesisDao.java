/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.dao;

import com.muet.model.Thesis;
import java.util.List;

/**
 *
 * @author khatr
 */
public interface ThesisDao {
    public Boolean addThesis(Thesis thesis);
    public Boolean updateThesis(Thesis thesis);
    public Boolean DeleteThesis(Integer id);
    public Thesis getThesisById(Integer id);
    public List<Thesis> getTheses();
}
