package javatrDay1.task7.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic7Test {

    @Test
    void comparePoint() {
        assertFalse(Logic7.comparePoint(0, 0, 0, 0));
        assertFalse(Logic7.comparePoint(1, 1, 0, 0));
        assertTrue(Logic7.comparePoint(1, 0, 1, 0));
        assertFalse(Logic7.comparePoint(-125, 15699, 0, 0));
    }
}