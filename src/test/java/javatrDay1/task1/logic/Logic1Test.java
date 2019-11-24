package javatrDay1.task1.logic;

import static org.junit.jupiter.api.Assertions.*;

class Logic1Test {


    @org.junit.jupiter.api.Test
    void findLastDigitSquareOfNumber() {
        assertEquals(1,Logic1.findLastDigitSquareOfNumber(1) );
        assertEquals(0,Logic1.findLastDigitSquareOfNumber(0) );
        assertEquals(1,Logic1.findLastDigitSquareOfNumber(-1) );
        assertEquals(4,Logic1.findLastDigitSquareOfNumber(-8) );
        assertEquals(5,Logic1.findLastDigitSquareOfNumber(25) );
    }
}