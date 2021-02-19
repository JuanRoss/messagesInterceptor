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
public class CommTest {
    
    public CommTest() {
    }

    /**
     * Test of equals method, of class Comm.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Msg m1 = new Msg("EFG", "ZYX", "Y", "t");
        List<Op> op1 = new ArrayList<>();
        op1.add(new Op("*", 6, 1));
        op1.add(new Op("-", 85, 6));
        m1.setOps(op1);
        Msg m2 = new Msg("EFG", "ZYX", "Y", "t");
        List<Op> op2 = new ArrayList<>();
        op2.add(new Op("*", 6, 1));
        op2.add(new Op("-", 85, 6));
        m2.setOps(op2);
        
        assertTrue(m2.equals(m1));
    }
    
}
