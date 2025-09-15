package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testAddNumbers() {
        assertEquals(5, App.addNumbers(2, 3));
    }
}