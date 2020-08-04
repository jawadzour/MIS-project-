/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.controller;

import com.google.gson.Gson;
import com.muet.dao.StudentDao;
import com.muet.daoimpl.StudentDaoImpl;
import com.muet.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 92310
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
         String action = request.getParameter("action");
        if(action.equals("add")){
            addData(request, response);
        }
        else if (action.equals("view")){
            viewData(request, response);
        }
       
    }
   private void viewData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student =new Student();
        PrintWriter pw=response.getWriter();
        StudentDao studentDao =new StudentDaoImpl();
        
        Gson gson = new Gson();
        pw.write(gson.toJson(student));
    }
    private void addData(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //To change body of generated methods, choose Tools | Templates.
        Student student =new Student();
        PrintWriter pw =response.getWriter();
        student.setFullName(request.getParameter("studentName"));
        student.setRollNumber(request.getParameter("studentRollNo"));
        pw.println(student.getFullName());
        StudentDao studentDao=(StudentDao) new StudentDaoImpl();
        studentDao.addStudent(student);
        
    }

    private void getFacultyRecord(HttpServletRequest request, HttpServletResponse response) {
        //To change body of generated methods, choose Tools | Templates.
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response) {
        //To change body of generated methods, choose Tools | Templates.
    }

    private void deleteData(HttpServletRequest request, HttpServletResponse response) {
        //To change body of generated methods, choose Tools | Templates.
    }

}
