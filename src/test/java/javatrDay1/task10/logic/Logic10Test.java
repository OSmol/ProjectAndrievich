package javatrDay1.task10.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic10Test {

    @Test
    void findFunction() {
        assertEquals(1.108, Logic10.findFunction(1, 2, 1));
        assertEquals(0.0, Logic10.findFunction(0, 0, 0));
        assertEquals(0.0, Logic10.findFunction(6,2,9));
        assertEquals(1.461, Logic10.findFunction(-3,9,2));

    }


}