package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatriceTest {

    @Test
    void testCalculate() {
        Calculatrice cal = new Calculatrice(12.0f,2.0f,'/');
        assertEquals(6.0f, cal.calculate());
        cal = new Calculatrice(12.0f,2.0f,'+');
        assertEquals(14.0f, cal.calculate());
        cal = new Calculatrice(12.0f,2.0f,'-');
        assertEquals(10.0f, cal.calculate());
        cal = new Calculatrice(12.0f,2.0f,'*');
        assertEquals(24.0f, cal.calculate());
    }

    @Test
    void testCalculateThrow() {
        Calculatrice cal = new Calculatrice(12.0f,0.0f,'w');
        assertThrows(IllegalArgumentException.class, cal::calculate);

        cal = new Calculatrice(12.0f,0.0f,'/');
        assertThrows(ArithmeticException.class, cal::calculate);
    }

    @Test
    void testAddition() {
        assertEquals(5.0f, Calculatrice.add(2.0f, 3.0f));
        assertEquals(-1.0f, Calculatrice.add(2.0f, -3.0f));
        assertEquals(0.0f, Calculatrice.add(0.0f, 0.0f));
    }

    @Test
    void testSoustraction() {
        assertEquals(1.0f, Calculatrice.substract(4.0f, 3.0f));
        assertEquals(7.0f, Calculatrice.substract(4.0f, -3.0f));
        assertEquals(-1.0f, Calculatrice.substract(2.0f, 3.0f));
    }

    @Test
    void testMultiplication() {
        assertEquals(6.0f, Calculatrice.multiplication(2.0f, 3.0f));
        assertEquals(0.0f, Calculatrice.multiplication(0.0f, 3.0f));
        assertEquals(-6.0f, Calculatrice.multiplication(-2.0f, 3.0f));
    }

    @Test
    void testDivision() {
        assertEquals(2.0f, Calculatrice.division(6.0f, 3.0f));
        assertEquals(-2.0f, Calculatrice.division(6.0f, -3.0f));
        assertEquals(0.5f, Calculatrice.division(1.0f, 2.0f));
    }

    @Test
    void testDivisionParZero() {
        assertThrows(ArithmeticException.class, () -> Calculatrice.division(5.0f, 0.0f));
        assertThrows(ArithmeticException.class, () -> Calculatrice.division(0.0f, 0.0f));
    }

    @Test
    void testIsEquals() {
        assertTrue(Calculatrice.isEquals(2.00001f, 2.00000f));
        assertTrue(Calculatrice.isEquals(1.000001f, 1.000000f));
        assertFalse(Calculatrice.isEquals(2.0f, 3.0f));
        assertTrue(Calculatrice.isEquals(0.0f, 0.0f));
    }
}
