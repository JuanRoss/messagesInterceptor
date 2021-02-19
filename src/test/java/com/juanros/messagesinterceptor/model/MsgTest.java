/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datumize.datumizeparser.model;

import com.juanros.messagesinterceptor.model.Msg;
import com.juanros.messagesinterceptor.model.Op;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Ros Pina
 */
public class MsgTest {
    private Msg request;
    private Msg response;
    
    public MsgTest() {
        request = new Msg("ABC", "XYZ", "a", "z");
        response = new Msg("XYZ", "ABC", "z", "a");
    }
    

    /**
     * Test of isResponse method, of class Msg.
     */
    @Test
    public void testIsResponse_Msg() {
        Op op1 = new Op("+", 1, 5);
        op1.calculateResult();
        
        Op op2 = new Op("-", op1.getResult(), 3);
        op2.calculateResult();
        
        List<Op> ops = new ArrayList<>();
        ops.add(op1);
        ops.add(op2);
        
        request.setOps(ops);
        
        Op op3 = new Op("=", 3, 0);
        op3.calculateResult();
        
        List<Op> ops2 = new ArrayList<>();
        ops2.add(op3);
        
        response.setOps(ops2);
 
        assertTrue(response.isResponse(request));
        
        ops2.clear();
        op3.setOperand1(5);
        op3.calculateResult();
        ops2.add(op3);
        
        assertFalse(response.isResponse(request));
    }

    /**
     * Test of isResponse method, of class Msg.
     */
    @Test
    public void testIsResponse_0args() {
        System.out.println("isResponse");
 
        List<Op> ops = new ArrayList<>();
        ops.add(new Op("=", 1, 0));
        request.setOps(ops);
        assertTrue(request.isResponse());
        
        request.getOps().add(new Op("=", 0, 0));
        assertFalse(request.isResponse());
        
        request.getOps().clear();
 
        request.getOps().add(new Op("+", 2, 3));
        assertFalse(request.isResponse());
    }

    /** 
     * Test of equals method, of class Msg.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Object();
        
        assertFalse(request.equals(o));
        
        Msg m = new Msg("ABC", "XYZ", "a", "z");
        assertTrue(request.equals(m));
        
        m.setDestinationIp(null);
        assertFalse(request.equals(m));
        
        m.setDestinationIp("XYZ");
        assertTrue(request.equals(m));
        
        m.setDestinationPort(null);
        assertFalse(request.equals(m));
        
        m.setDestinationPort("z");
        assertTrue(request.equals(m));
        
        m.setOriginIp(null);
        assertFalse(request.equals(m));
        
        m.setOriginIp("ABC");
        assertTrue(request.equals(m));
        
        m.setOriginPort(null);
        assertFalse(request.equals(m));
        
        m.setOriginPort("a");
        assertTrue(request.equals(m));
    }

    
}
