package com.ufasoli.simple.unit.tests.tests;

import org.junit.Test;

import static org.junit.Assert.*;

public class ATest {

    @Test
    public void failTest() {
        assertTrue(false);
    }

    @Test
    public void successTest() {
       assertTrue(true);

    }
}