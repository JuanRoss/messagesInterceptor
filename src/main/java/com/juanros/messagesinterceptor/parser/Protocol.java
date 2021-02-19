/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

/**
 *
 * @author juan
 */
public interface Protocol {
    
    public void parseMessage(byte[] frame);
    
}
