/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juanros.messagesinterceptor.parser;

import com.juanros.messagesinterceptor.parser.Utils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan Ros Pina
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @Test
    public void testAsciiArrayToInt() {
        
        System.out.println("asciiArrayToInt");
        
        int result = Utils.asciiArrayToInt("12".getBytes());
        assertEquals(12, result);
        result = Utils.asciiArrayToInt("0000000009".getBytes());
        assertEquals(9, result);
        result = Utils.asciiArrayToInt("0001000009".getBytes());
        assertEquals(1000009, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAsciiArrayToIntException() {
        Utils.asciiArrayToInt("not_numeric_string".getBytes());
    }

    @Test
    public void testGetCharsRemainingToFirstAppearance() {
        System.out.println("getCharsRemainingToFirstAppearance");
        String frame = "1154%32";
        int result = Utils.getCharsRemainingToFirstAppearance(frame.getBytes(), "%", 1);
        assertEquals(3, result);
        result = Utils.getCharsRemainingToFirstAppearance(frame.getBytes(), "%", 0);
        assertEquals(4, result);
        result = Utils.getCharsRemainingToFirstAppearance(frame.getBytes(), "1", 0);
        assertEquals(0, result);
        result = Utils.getCharsRemainingToFirstAppearance(frame.getBytes(), "2", 0);
        assertEquals(6, result);
        result = Utils.getCharsRemainingToFirstAppearance(frame.getBytes(), "%", 5);
        assertEquals(-1, result);
    }
    
    /*@Test(expected = IllegalArgumentException.class)
    public void testGetCharsRemainingToFirstAppearanceException() {
        String frame = "1154%32";
        Utils.getCharsRemainingToFirstAppearance(frame.getBytes(), "%", 5);
    }*/
}
