package javatrDay1.task3.logic;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic3Test {

    @Test
    void testFindSquareAreaInCircle() {
        assertEquals(12.5, Logic3.findSquareAreaInCircle(25));
        assertEquals(0, Logic3.findSquareAreaInCircle(-3));
        assertEquals(0, Logic3.findSquareAreaInCircle(0));
        assertEquals(6.172839449999999E7, Logic3.findSquareAreaInCircle(123456789));
    }

    @Test
    void testFindDifferenceBetweenSquares() {

    }
}