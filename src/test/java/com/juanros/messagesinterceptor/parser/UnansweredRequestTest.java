/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

import com.juanros.messagesinterceptor.parser.UnansweredRequest;
import com.juanros.messagesinterceptor.model.Msg;
import com.juanros.messagesinterceptor.model.Op;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Juan Ros Pina
 */
public class UnansweredRequestTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
     /**
     * Test of addUnansweredRequest and getUnansweredRequest methods, of class UnansweredRequest.
     */
    @Test
    public void testAddUnansweredRequest() {
        System.out.println("addUnansweredRequest");
        UnansweredRequest instance = new UnansweredRequest();
        Msg request = new Msg("EFG", "ZYX", "Y", "t");
        List<Op> op1 = new ArrayList<>();
        op1.add(new Op("*", 6, 1));
        op1.add(new Op("-", 85, 6));
        request.setOps(op1);
        instance.addUnansweredRequest(request);
        assertTrue(instance.hasRequests());
        Msg response1 = new Msg("ZYX", "EFG", "t", "Y");
        List<Op> op2 = new ArrayList<>();
        op2.add(new Op("=", 79, 0));
        response1.setOps(op2);
        Msg request1 = instance.getUnansweredRequest(response1);
        
        assertTrue(request.equals(request1));
        assertFalse(instance.hasRequests());
        
    }


    /**
     * Test of hasRequests method, of class UnansweredRequest.
     */
   /* @Test
    public void testHasRequests() {
        System.out.println("hasRequests");
        UnansweredRequest instance = new UnansweredRequest();
        
        Msg request = new Msg("EFG", "ZYX", "Y", "t");
        List<Op> op1 = new ArrayList<>();
        op1.add(new Op("*", 6, 1));
        op1.add(new Op("-", 85, 6));
        request.setOps(op1);
        instance.addUnansweredRequest(request);
        assertTrue(instance.hasRequests());
        
        List<Msg> messages = instance.clear();
        assertFalse(instance.hasRequests());
        
        for(Msg m : messages)
            assertTrue(m.equals(request));
    }*/
   
}
