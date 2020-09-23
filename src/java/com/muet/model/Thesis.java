/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.model;

/**
 *
 * @author khatr
 */
public class Thesis {
    private Integer thesisId;
    private String thesisTitle;
    private String thesisExamDate;
    private Integer finalResults;
    private String remarks;
    private Student student;
    
    public Thesis() {}

    public Integer getThesisId() {
        return thesisId;
    }

    public void setThesisId(Integer thesisId) {
        this.thesisId = thesisId;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String getThesisExamDate() {
        return thesisExamDate;
    }

    public void setThesisExamDate(String thesisExamDate) {
        this.thesisExamDate = thesisExamDate;
    }

    public Integer getFinalResults() {
        return finalResults;
    }

    public void setFinalResults(Integer finalResults) {
        this.finalResults = finalResults;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
      
}
