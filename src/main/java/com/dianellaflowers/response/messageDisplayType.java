/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dianellaflowers.response;
/**
 *
 * @author Mahmoud
 */
public class messageDisplayType {

    private Integer statusCode;
    private Integer messageDisplayType;
    private String statusMessage;
    private Object responseObject;

    public messageDisplayType(Integer statusCode, Integer messageDisplayType, String statusMessage, Object responseObject) {
        this.statusCode = statusCode;
        this.messageDisplayType = messageDisplayType;
        this.statusMessage = statusMessage;
        this.responseObject = responseObject;
    }

    public messageDisplayType() {
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getMessageDisplayType() {
        return messageDisplayType;
    }

    public void setMessageDisplayType(int messageDisplayType) {
        this.messageDisplayType = messageDisplayType;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

}
