package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameFormatterTest {

    @Test
    public void testFirstLast(){
        assertEquals("Mainali, Amit", NameFormatter.format("Amit", "Mainali"));
    }

    @Test
    public void testFullName(){
        assertEquals("Mainali, Mr. Amit, MEng", NameFormatter.format("Mr. Amit Mainali, MEng"));
    }

}