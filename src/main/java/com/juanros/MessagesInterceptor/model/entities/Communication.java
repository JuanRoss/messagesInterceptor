/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.model.entities;

import com.juanros.MessagesInterceptor.model.Msg;
import javax.persistence.Id;

/**
 *
 * @author juan
 */
public class Communication {
    @Id
    private String id;
    
    private Msg request;
    
    private Msg response;

    public Communication() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Msg getRequest() {
        return request;
    }

    public void setRequest(Msg request) {
        this.request = request;
    }

    public Msg getResponse() {
        return response;
    }

    public void setResponse(Msg response) {
        this.response = response;
    }

}
