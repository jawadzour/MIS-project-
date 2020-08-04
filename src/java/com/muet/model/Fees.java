/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muet.model;

import java.sql.Timestamp;

/**
 *
 * @author khatr
 */
public class Fees {
    private Integer feesId;
    private String feesTitle;
    private Integer amount;
    private Timestamp announcementDate;
    private Timestamp dueDate;
    
    public Fees() {}

    public Integer getFeesId() {
        return feesId;
    }

    public void setFeesId(Integer feesId) {
        this.feesId = feesId;
    }

    public String getFeesTitle() {
        return feesTitle;
    }

    public void setFeesTitle(String feesTitle) {
        this.feesTitle = feesTitle;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Timestamp getAnnouncementDate() {
        return announcementDate;
    }

    public void setAnnouncementDate(Timestamp announcementDate) {
        this.announcementDate = announcementDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }
    
    
}
