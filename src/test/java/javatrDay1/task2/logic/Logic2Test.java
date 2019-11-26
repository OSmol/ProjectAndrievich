package javatrDay1.task2.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic2Test {

    @Test
    void countOfDaysThisYear() {
        assertEquals(29, Logic2.countOfDaysThisYear(2,12));
        assertEquals(0, Logic2.countOfDaysThisYear(0,0));
        assertEquals(0, Logic2.countOfDaysThisYear(-2,-123));
        assertEquals(0, Logic2.countOfDaysThisYear(123,123));
    }


}