/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.model;

/**
 *
 * @author 92310
 */
public class SeminarGroup {
    private Integer seminarGroupId;
    private Seminar seminar;
    private Thesis thesis;

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
    private String dateApplied;
    private String dateConducted;
    private String remarks;
    private String comments;
    private String status ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSeminarGroupId() {
        return seminarGroupId;
    }

    public void setSeminarGroupId(Integer seminarGroupId) {
        this.seminarGroupId = seminarGroupId;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }

    public String getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(String dateApplied) {
        this.dateApplied = dateApplied;
    }

    public String getDateConducted() {
        return dateConducted;
    }

    public void setDateConducted(String dateConducted) {
        this.dateConducted = dateConducted;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
}
