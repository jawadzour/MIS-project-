/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.controller;

import com.google.gson.Gson;
import com.muet.dao.StudentFeesDao;
import com.muet.daoimpl.StudentFeesDaoImpl;
import com.muet.model.Fees;
import com.muet.model.Student;
import com.muet.model.StudentFees;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author khatr
 */
public class FeesDetailsController extends HttpServlet {

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
                case "getStudentFeesRecord":
                    getStudentFeesRecord(request, response);
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
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    private void viewData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentFeesDao studentFeesDao = new StudentFeesDaoImpl();
        List<StudentFees> studentFeeses = studentFeesDao.getStudentFee();
        Gson gson = new Gson();
        PrintWriter pw = response.getWriter();
        pw.write(gson.toJson(studentFeeses));
    }

    private void addData(HttpServletRequest request, HttpServletResponse response) {
        StudentFees studentFees = new StudentFees();
        Student student = new Student();
        student.setStudentId(Integer.parseInt(request.getParameter("studentId")));
        studentFees.setStudent(student);
        Fees fees = new Fees();
        fees.setFeesId(Integer.parseInt(request.getParameter("feesId")));
        studentFees.setFees(fees);
        studentFees.setDatePaid(request.getParameter("datePaid"));
        studentFees.setAmountPaid(Integer.parseInt(request.getParameter("amountPaid")));
        studentFees.setLateFees(Integer.parseInt(request.getParameter("lateFee")));
        studentFees.setChallanNumber(Integer.parseInt(request.getParameter("challanNumber")));
        StudentFeesDao studentFeesDao = new StudentFeesDaoImpl();
        studentFeesDao.addStudentFees(studentFees);
    }

    private void getStudentFeesRecord(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentFeesDao studentFeesDao = new StudentFeesDaoImpl();
        StudentFees studentFees = studentFeesDao.getStudentFeesById(Integer.parseInt(request.getParameter("studentFeesId")));
        System.out.println("---------------------> " + request.getParameter("studentFeesId"));
        System.out.println("---------------------> " + studentFees.getStudent().getStudentId());
        Gson gson = new Gson();
        PrintWriter pw = response.getWriter();
        pw.write(gson.toJson(studentFees));
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response) {
        StudentFees studentFees = new StudentFees();
        studentFees.setStudentFeesId(Integer.parseInt(request.getParameter("studentFeesId")));
        Student student = new Student();
        student.setStudentId(Integer.parseInt(request.getParameter("studentId")));
        studentFees.setStudent(student);
        Fees fees = new Fees();
        fees.setFeesId(Integer.parseInt(request.getParameter("feesId")));
        studentFees.setFees(fees);
        studentFees.setDatePaid(request.getParameter("datePaid"));
        studentFees.setAmountPaid(Integer.parseInt(request.getParameter("amountPaid")));
        studentFees.setLateFees(Integer.parseInt(request.getParameter("lateFee")));
        studentFees.setChallanNumber(Integer.parseInt(request.getParameter("challanNumber")));
        StudentFeesDao studentFeesDao = new StudentFeesDaoImpl();
        studentFeesDao.updateStudentFees(studentFees);
    }

    private void deleteData(HttpServletRequest request, HttpServletResponse response) {
        StudentFeesDao studentFeesDao = new StudentFeesDaoImpl();
        Integer id = Integer.parseInt(request.getParameter("studentFeesId"));
        studentFeesDao.deleteStudentFees(id);
    }

   

}
