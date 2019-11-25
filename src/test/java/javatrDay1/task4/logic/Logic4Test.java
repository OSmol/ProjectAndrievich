package javatrDay1.task4.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic4Test {

    @Test
    void takeNumbers() {
        assertEquals(1, Logic4.takeNumbers(1,8,7,7));
        assertEquals(3, Logic4.takeNumbers(-999,8,6,8));
        assertEquals(1, Logic4.takeNumbers(1,8,7,7));
        assertEquals(0, Logic4.takeNumbers(0,0,0,0));
    }
}