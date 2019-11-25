package javatrDay1.task9.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic9Test {

    @Test
    void getLengthCircle() {
        assertEquals(157.0, Logic9.getLengthCircle(25));
    }

    @Test
    void getSquareCircle() {
        assertEquals(1962.5, Logic9.getSquareCircle(25));
    }
}