package com.tcs.junit.first;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tcs.junit.first.MyClass;

class MyClassTest {

    @Test
    void testExceptionIsThrown() {
        MyClass tester = new MyClass();
        assertThrows(IllegalArgumentException.class, () -> tester.multiply(100, 5));
    }

    @Test
    void testMultiply() {
        MyClass tester = new MyClass();
        assertEquals(50, tester.multiply(10, 5), "10 x 5 must be 50");
    }
}