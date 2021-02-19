/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

import com.juanros.messagesinterceptor.parser.Parser;
import com.juanros.messagesinterceptor.parser.UnansweredRequest;
import com.juanros.messagesinterceptor.model.Comm;
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
public class ParserTest {
    private final static String raw1 = "ABCXYZ18#ui13#2+[2#2]-[*#3]EFGZYX19#Yt14#2*[6#1]-[85#*]ZYXEFG12#tY8#1=[79#-]XYZABC11#iu7#1=[1#-]";
    private final static String raw2 = "ABCXYZ18#ui13#2+[2#2]-[*#3]EFGZYX19#Yt14#2*[6#1]-[85#*]ZYXEFG12#tY8#1=[79#-]";
    private final static String raw3 = "XYZABC11#iu7#1=[1#-]";
    private final static String raw4 = "ABCXYZ18#ui13#2+[2#2]-[*#3]";
    private final static String raw5 = "EFGZYX19#Yt14#2*[6#1]-[85#*]";
    
    public ParserTest() {
    }

    /**
     * Test of crunch method, of class ExampleParser.
     */
    @Test
    public void testCrunch_completeCommunication() {
        System.out.println("crunch");
        /*Parser parser = new Parser();
        List<Comm> result = parser.crunch(raw1.getBytes());
        
        List<Comm> expected = new ArrayList<>();
        
        Msg request1 = new Msg("EFG", "ZYX", "Y", "t");
        List<Op> op1 = new ArrayList<>();
        op1.add(new Op("*", 6, 1));
        op1.add(new Op("-", 85, 6));
        request1.setOps(op1);
        Msg response1 = new Msg("ZYX", "EFG", "t", "Y");
        List<Op> op2 = new ArrayList<>();
        op2.add(new Op("=", 79, 0));
        response1.setOps(op2);
        
        Comm com1 = new Comm(request1, response1);
        expected.add(com1);
        
        
        Msg request2 = new Msg("ABC", "XYZ", "u", "i");
        List<Op> op3 = new ArrayList<>();
        op3.add(new Op("+", 2, 2));
        op3.add(new Op("-", 4, 3));
        request1.setOps(op1);
        Msg response2 = new Msg("XYZ", "ABC", "i", "u");
        List<Op> op4 = new ArrayList<>();
        op4.add(new Op("=", 1, 0));
        response2.setOps(op2);
        Comm com2 = new Comm(request2, response2);
        expected.add(com2);
        
        assertTrue(result.size() == expected.size());
        
        for(int i=0; i<result.size(); i++)
            assertTrue(result.get(i).equals(expected.get(i)));*/
        
    }
    
    @Test
    public void testCrunch_incompleteCommunication() {
        System.out.println("crunch");
        /*Parser parser = new Parser();
        List<Comm> result = parser.crunch(raw2.getBytes());
        
        List<Comm> expected = new ArrayList<>();
        
        Msg request1 = new Msg("EFG", "ZYX", "Y", "t");
        List<Op> op1 = new ArrayList<>();
        op1.add(new Op("*", 6, 1));
        op1.add(new Op("-", 85, 6));
        request1.setOps(op1);
        Msg response1 = new Msg("ZYX", "EFG", "t", "Y");
        List<Op> op2 = new ArrayList<>();
        op2.add(new Op("=", 79, 0));
        response1.setOps(op2);
        
        Comm com1 = new Comm(request1, response1);
        expected.add(com1);
        
        assertTrue(result.size() == expected.size());
        
        for(int i=0; i<result.size(); i++)
            assertTrue(result.get(i).equals(expected.get(i)));
        
        
        //assertTrue(ur.hasRequests());
        
        expected.clear();
        
        Msg request2 = new Msg("ABC", "XYZ", "u", "i");
        List<Op> op3 = new ArrayList<>();
        op3.add(new Op("+", 2, 2));
        op3.add(new Op("-", 4, 3));
        request1.setOps(op1);
        Msg response2 = new Msg("XYZ", "ABC", "i", "u");
        List<Op> op4 = new ArrayList<>();
        op4.add(new Op("=", 1, 0));
        response2.setOps(op2);
        Comm com2 = new Comm(request2, response2);
        expected.add(com2);
        
        result = parser.crunch(raw3.getBytes());

        for(Comm c : result)
            System.out.println(c);
        
        assertTrue(result.size() == expected.size());
        
        for(int i=0; i<result.size(); i++)
            assertTrue(result.get(i).equals(expected.get(i)));*/
        
        //assertFalse(ur.hasRequests());
        
    }
    
    
    
}
