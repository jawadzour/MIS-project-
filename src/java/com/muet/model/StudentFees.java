/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.model;

import java.util.Date;

/**
 *
 * @author khatr
 */
public class StudentFees {
    private Integer studentFeesId;
    private Student student;
    private Fees fees;
    private Date datePaid;
    private Integer amountPaid;
    private Integer lateFees;
    private Integer challanNumber;
    
    public StudentFees() {}

    public Integer getStudentFeesId() {
        return studentFeesId;
    }

    public void setStudentFeesId(Integer studentFeesId) {
        this.studentFeesId = studentFeesId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    public Date getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Date datePaid) {
        this.datePaid = datePaid;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Integer getLateFees() {
        return lateFees;
    }

    public void setLateFees(Integer lateFees) {
        this.lateFees = lateFees;
    }

    public Integer getChallanNumber() {
        return challanNumber;
    }

    public void setChallanNumber(Integer challanNumber) {
        this.challanNumber = challanNumber;
    }
    
    
    
}
