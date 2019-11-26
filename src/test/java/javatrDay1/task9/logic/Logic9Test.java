package javatrDay1.task9.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic9Test {

    @Test
    void getLengthCircle() {
        assertEquals(157.0, Logic9.getLengthCircle(25));
        assertEquals(0.0, Logic9.getLengthCircle(0));
        assertEquals(-157.0, Logic9.getLengthCircle(-25));
        assertEquals(6.28, Logic9.getLengthCircle(1));
        assertEquals(7.753086349200001E8, Logic9.getLengthCircle(123456789));
    }

    @Test
    void getSquareCircle() {
        assertEquals(1962.5, Logic9.getSquareCircle(25));
        assertEquals(0.0, Logic9.getLengthCircle(0));
        assertEquals(1962.5, Logic9.getLengthCircle(-25));
        assertEquals(3.14, Logic9.getLengthCircle(1));
        assertEquals(4.7858557275598232E16, Logic9.getLengthCircle(123456789));
    }
}