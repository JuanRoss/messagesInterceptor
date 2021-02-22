/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.MessagesInterceptor.unansweredrequest;

import com.juanros.MessagesInterceptor.model.Msg;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juan Ros Pina
 */

public class UnansweredRequest {
    private List<Msg> requests;
    private static final Object lock = new Object();
    
    
    public UnansweredRequest() {
        requests = new LinkedList<>();
    }
    
    public Msg getUnansweredRequest(Msg response) {
        synchronized(lock) {
            for(Msg request : requests) {
                if(response.isResponse(request)) {
                    requests.remove(request);
                    return request;
                }
            }
            return null;
        }
    }
    
    public void addUnansweredRequest(Msg request) {
        synchronized(lock) {
            requests.add(request);
        }
    }
    
    public boolean hasRequests() {
        synchronized(lock) {
            return !requests.isEmpty();
        }
    }
    
    public List<Msg> clear() {
        synchronized(lock) {
            List<Msg> messages = new ArrayList<>(); 
            for(Msg m : requests) {
                messages.add(m);
            }
            requests.clear();
            return messages;
        }
    }

    public List<Msg> getRequests() {
        synchronized(lock) {
            return requests;
        }
    }
}
