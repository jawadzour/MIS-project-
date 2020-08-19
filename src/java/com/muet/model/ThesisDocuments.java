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
public class ThesisDocuments {
    private Integer thesisDocumentId;
    private String thesisDocumentTitle;
    private Thesis thesis;
    
    public ThesisDocuments() {}

    public Integer getThesisDocumentId() {
        return thesisDocumentId;
    }

    public void setThesisDocumentId(Integer thesisDocumentId) {
        this.thesisDocumentId = thesisDocumentId;
    }

    public String getThesisDocumentTitle() {
        return thesisDocumentTitle;
    }

    public void setThesisDocumentTitle(String thesisDocumentTitle) {
        this.thesisDocumentTitle = thesisDocumentTitle;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
    
    
    
}
