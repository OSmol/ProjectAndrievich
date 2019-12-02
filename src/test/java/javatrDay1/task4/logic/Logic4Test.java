package javatrDay1.task4.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic4Test {

    @Test
    void takeNumbers() {
        assertFalse(Logic4.takeNumbers(1, 8, 7, 7));
        assertTrue(Logic4.takeNumbers(-999, 8, 6, 8));
        assertFalse(Logic4.takeNumbers(1, 8, 7, 7));
        assertFalse(Logic4.takeNumbers(0, 0, 0, 0));
    }
}