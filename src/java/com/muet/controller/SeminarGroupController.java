/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.controller;

import com.google.gson.Gson;
import com.muet.dao.SeminarDao;
import com.muet.dao.SeminarGroupDao;
import com.muet.dao.ThesisDao;
import com.muet.daoimpl.SeminarDaoImpl;
import com.muet.daoimpl.SeminarGroupDaoImpl;
import com.muet.daoimpl.ThesisDaoImpl;
import com.muet.model.Seminar;
import com.muet.model.SeminarGroup;
import com.muet.model.Thesis;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 92310
 */
public class SeminarGroupController extends HttpServlet {

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
                case "getSeminarGroupRecord":
                    getSeminarGroupRecord(request, response);
                    break;
                case "update":
                    updateData(request, response);
                    break;
                case "delete":
                    deleteData(request, response);
                    break;
                case "showStudentSeminarRecords":
                    showStudentSeminarRecords(request, response);
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
        System.out.println("View is working");
        SeminarGroupDao seminarGroupDao = new SeminarGroupDaoImpl();
        PrintWriter pw = response.getWriter();
        List<SeminarGroup> seminarGroup = seminarGroupDao.getSeminarGroups();
        Gson gson = new Gson();
        pw.write(gson.toJson(seminarGroup));

    }

    

    private void getSeminarGroupRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("seminarGroupId"));   
        SeminarGroupDao seminarGroupDao = new SeminarGroupDaoImpl();
        PrintWriter pw = response.getWriter();
        SeminarGroup seminarGroup=seminarGroupDao.getSeminarGroupById(id);
        Gson gson = new Gson();
        pw.write(gson.toJson(seminarGroup));
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response) {
        SeminarGroup seminarGroup = new SeminarGroup();
        seminarGroup.setSeminarGroupId(Integer.parseInt(request.getParameter("seminarGroupId")));
        seminarGroup.setDateConducted(request.getParameter("dateConducted"));
        seminarGroup.setDateApplied(request.getParameter("dateApplied"));
        seminarGroup.setRemarks(request.getParameter("remarks"));
        seminarGroup.setComments(request.getParameter("comments"));
        seminarGroup.setStatus(request.getParameter("status"));
        Integer id =Integer.parseInt(request.getParameter("seminarId"));
        Integer thesisId=Integer.parseInt(request.getParameter("thesisId"));
        SeminarDao seminarDao=new SeminarDaoImpl();
        Seminar seminar=new Seminar();
        seminar.setSeminarId(id);
        seminar.setSeminarTitle(request.getParameter("seminarTitle"));
        seminarGroup.setSeminar(seminar);
        Thesis thesis =new Thesis();
        ThesisDao thesisDao =new ThesisDaoImpl();
        thesis.setThesisId(thesisId);
        thesis.setThesisTitle(request.getParameter("thesisTitle"));
        seminarGroup.setThesis(thesis);
        SeminarGroupDao seminarGroupDao = new SeminarGroupDaoImpl();
        seminarGroupDao.updateSeminarGroup(seminarGroup);
    }

    private void deleteData(HttpServletRequest request, HttpServletResponse response) {
        SeminarGroupDao seminarGroupDao = new SeminarGroupDaoImpl();
        Integer id = Integer.parseInt(request.getParameter("seminarGroupId"));
        seminarGroupDao.deleteSeminarGroup(id);
    }

    private void getSeminarRecord(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showStudentSeminarRecords(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer studentId = Integer.parseInt(request.getParameter("studentId"));
        SeminarGroupDao seminarGroupDao = new SeminarGroupDaoImpl();
        List<SeminarGroup> seminarGroups = seminarGroupDao.getSeminarGroupsByStudentId(studentId);
        System.out.println(seminarGroups.get(0).getSeminarGroupId());
        PrintWriter pw = response.getWriter();
        Gson gson = new Gson();
        pw.write(gson.toJson(seminarGroups));
    }


}
