/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.controller;

import com.google.gson.Gson;
import com.muet.dao.DepartmentDao;
import com.muet.dao.StudentDao;
import com.muet.daoimpl.DepartmentDaoImpl;
import com.muet.daoimpl.StudentDaoImpl;
import com.muet.model.Department;
import com.muet.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private Integer studentId = 0;

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
        if (action.equals("add")) {
            addData(request, response);
        } else if (action.equals("view")) {
            viewData(request, response);
        } else if (action.equals("delete")) {
            deleteData(request, response);
        } else if (action.equals("getStudentRecord")) {
            getStudentRecord(request, response);
        } else if (action.equals("getStudentProfileRecord")) {
            getStudentProfileRecord(request, response);
        } else if (action.equals("update")) {
            updateData(request, response);
        }

    }

    private void viewData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Student();
        PrintWriter pw = response.getWriter();
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> std = studentDao.getStudents();
        Gson gson = new Gson();
        pw.write(gson.toJson(std));
    }

    private void addData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //To change body of generated methods, choose Tools | Templates.
        Student student = new Student();
        PrintWriter pw = response.getWriter();
        student.setFullName(request.getParameter("studentName"));
        student.setRollNumber(request.getParameter("studentRollNo"));
        pw.println(student.getFullName());
        StudentDao studentDao = (StudentDao) new StudentDaoImpl();
        studentDao.addStudent(student);

    }

    private void getStudentRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //To change body of generated methods, choose Tools | Templates.

        StudentDao studentDao = new StudentDaoImpl();
        PrintWriter pw = response.getWriter();
        int id = Integer.parseInt(request.getParameter("studentId"));
        studentId = id;
        Student student = studentDao.getStudentById(id);
        Gson gson = new Gson();
        pw.write(gson.toJson(student));
    }

    private void updateData(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        //To change body of generated methods, choose Tools | Templates.

        Student student = new Student();
        StudentDao studentDao = new StudentDaoImpl();
        Integer id = Integer.parseInt(request.getParameter("studentId"));
        student.setStudentId(id);
        student.setAddress(request.getParameter("address"));
        student.setAdmissionDate(request.getParameter("admissionDate"));
        student.setBatch(request.getParameter("batch"));
        student.setBloodGroup(request.getParameter("bloodGroup"));
        student.setCountryOfBirth(request.getParameter("countryOfBirth"));
        student.setCurrentAddress(request.getParameter("currentAddress"));
        student.setDob(request.getParameter("dob"));
        student.setDomicile(request.getParameter("domicile"));
        student.setEmail(request.getParameter("email"));
        student.setFathersName(request.getParameter("fathersName"));
        student.setFieldProgram(request.getParameter("fieldProgram"));
        student.setFullName(request.getParameter("fullName"));
        student.setLegalId(request.getParameter("legalId"));
        student.setLegalIdNo(request.getParameter("legalIdNo"));
        student.setMobile(request.getParameter("mobile"));
        student.setNationality(request.getParameter("nationality"));
        student.setPlaceOfIssueOfLegalId(request.getParameter("placeOfIssueOfLegalId"));
        student.setProgram(request.getParameter("program"));
        student.setReligion(request.getParameter("religion"));
        student.setRollNumber(request.getParameter("rollNumber"));
        student.setSemester(Integer.parseInt(request.getParameter("semester")));
        student.setShift(request.getParameter("shift"));
        student.setTiming(request.getParameter("timing"));
        Integer departmentId = Integer.parseInt(request.getParameter("departmentId"));
        String departmentName = request.getParameter("departmentName");
        Department department = new Department();
        DepartmentDao departmentDao = new DepartmentDaoImpl();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        departmentDao.updateDepartmentOnly(department);
        student.setDepartment(department);
        studentDao.updateStudent(student);
    }

    private void deleteData(HttpServletRequest request, HttpServletResponse response) {
        //To change body of generated methods, choose Tools | Templates.
        StudentDao studentDao = new StudentDaoImpl();
        Integer id = Integer.parseInt(request.getParameter("studentId"));
        studentDao.deleteStudent(id);
    }

    private void getStudentProfileRecord(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //To change body of generated methods, choose Tools | Templates.
        StudentDao studentDao = new StudentDaoImpl();
        PrintWriter pw = response.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Student student = studentDao.getStudentById(id);
        Gson gson = new Gson();
        pw.write(gson.toJson(student));

    }

}
