package javatrDay1.task8.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic8Test {

    @Test
    void findFunction() {
        assertEquals(-0.167, Logic8.findFunction(0));
        assertEquals(-0.008, Logic8.findFunction(-5));
    }
}