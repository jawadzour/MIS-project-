/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.dao;

import com.muet.model.Student;
import java.util.List;

/**
 *
 * @author 92310
 */
public interface StudentDao {
    public Integer addStudent(Student student);
    
    /**
     *
     * @param student 
     * @return 
     */
    
    public Boolean updateStudent(Student student);
    
    /**
     * @param id
     * @return 
     */
    
    public Boolean deleteStudent(Integer id );

    /**
     *
     * @param id
     * @return 
     */

    public Student getFacultyById(Integer id);
    
    /**
     *
     * @return List of Faculty
     */
    public List<Student> getFaculties();
    /**
     *
     * @param studentName
     * @return 
     */

    public Student getFacultyByFacultyName(String studentName);
}
