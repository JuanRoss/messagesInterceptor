/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datumize.datumizeparser.model;

import com.juanros.messagesinterceptor.model.Op;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Ros Pina
 */
public class OpTest {
    
    public OpTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of calculateResult method, of class Op.
     */
    @Test
    public void testCalculateResult() {
        System.out.println("calculateResult");
        Op op1 = new Op("+", 5, 5);
        op1.calculateResult();
        assertEquals(10, op1.getResult());
        op1 = new Op("-", 5, 7);
        op1.calculateResult();
        assertEquals(-2, op1.getResult());
        op1 = new Op("*", 5, 5);
        op1.calculateResult();
        assertEquals(25, op1.getResult());
        op1 = new Op("/", 20, 5);
        op1.calculateResult();
        assertEquals(4, op1.getResult());
        op1 = new Op("/", 22, 5);
        op1.calculateResult();
        assertEquals(4, op1.getResult());
        op1 = new Op("=", 5, 10);
        op1.calculateResult();
        assertEquals(5, op1.getResult());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateResultException() {
        Op op1 = new Op("bad_operator", 5, 5);
        op1.calculateResult();
    }

    /**
     * Test of equals method, of class Op.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Op op1 = new Op("+", 5, 5);
        Op op2 = new Op("+", 5, 5);
        Op op3 = new Op("-", 5, 5);
        Op op4 = new Op("+", 6, 5);
        Op op5 = new Op("+", 5, 7);
        
        assertTrue(op1.equals(op2));
        assertFalse(op1.equals(op3));
        assertFalse(op1.equals(op4));
        assertFalse(op1.equals(op5));
    }    
}
