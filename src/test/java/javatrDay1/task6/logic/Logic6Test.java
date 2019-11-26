package javatrDay1.task6.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic6Test {

    @Test
    void countOfSecondsToThisMoment() {
        assertEquals(1, Logic6.countOfSecondsToThisMoment(1));
        assertEquals(0, Logic6.countOfSecondsToThisMoment(0));
        assertEquals(-1, Logic6.countOfSecondsToThisMoment(-1));
        assertEquals(1236, Logic6.countOfSecondsToThisMoment(1236));
    }
}