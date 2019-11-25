package javatrDay1.task5.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Logic5Test {

    @Test
    void findDividersOfNumberAndSum() {
        assertTrue(Logic5.findDividersOfNumberAndSum(6));
        assertFalse(Logic5.findDividersOfNumberAndSum(22));
        assertFalse(Logic5.findDividersOfNumberAndSum(-6));
        assertTrue(Logic5.findDividersOfNumberAndSum(0));
    }
}