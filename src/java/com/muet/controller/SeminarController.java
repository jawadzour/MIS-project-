/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.controller;

import com.google.gson.Gson;
import com.muet.dao.SeminarDao;
import com.muet.daoimpl.SeminarDaoImpl;
import com.muet.model.Seminar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 92310
 */
@WebServlet(name = "SeminarController", urlPatterns = {"/SeminarController"})
public class SeminarController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (null == action) {
            viewData(request, response);
        } else {
            switch (action) {
                case "":
                case "view":
                    viewData(request, response);
                    break;
                case "add":
                    addData(request, response);
                    break;
                case "getSeminarRecord":
                    getSeminarRecord(request, response);
                    break;
                case "update":
                    updateData(request, response);
                    break;
                case "delete":
                    deleteData(request, response);
                    break;
                default:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void viewData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SeminarDao seminarDao = new SeminarDaoImpl();
        PrintWriter pw = response.getWriter();
        List<Seminar> seminar = seminarDao.getSeminars();
        Gson gson = new Gson();
        pw.write(gson.toJson(seminar));
    }

    private void addData(HttpServletRequest request, HttpServletResponse response) {
        Seminar seminar = new Seminar();
        seminar.setSeminarTitle(request.getParameter("seminarTitle"));
        SeminarDao seminarDao = new SeminarDaoImpl();
        seminarDao.addSeminar(seminar);
    }

    private void getFacultyRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("seminarId"));   
        SeminarDao seminarDao = new SeminarDaoImpl();
        PrintWriter pw = response.getWriter();
        Seminar seminar=seminarDao.getSeminarById(id);
        Gson gson = new Gson();
        pw.write(gson.toJson(seminar));
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response) {
        Seminar seminar = new Seminar();
        seminar.setSeminarId(Integer.parseInt(request.getParameter("seminarId")));
        seminar.setSeminarTitle(request.getParameter("seminarTitle"));
        SeminarDao seminarDao = new SeminarDaoImpl();
        seminarDao.updateSeminar(seminar);
    }

    private void deleteData(HttpServletRequest request, HttpServletResponse response) {
        SeminarDao seminarDao = new SeminarDaoImpl();
        Integer id = Integer.parseInt(request.getParameter("seminarId"));
        seminarDao.deleteSeminar(id);
    }

    private void getSeminarRecord(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
