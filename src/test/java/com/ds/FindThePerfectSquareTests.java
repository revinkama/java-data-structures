package com.ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindThePerfectSquareTests {
    @Test
    public void findThePerfectSquareTests() {
        FindThePerfectSquares findTheSquares = new FindThePerfectSquares();
        Integer[] numbers = new Integer[]{1, 33, 4, 16, 9, 55, 2};
        List<Integer> expected = new ArrayList<>();
        List<Integer> response = findTheSquares.findEvenSquares(numbers);
        expected.add(1);
        expected.add(4);
        expected.add(9);
        expected.add(16);
        Assert.assertEquals(4, response.size());
        for (int i = 0; i < response.size(); i++) {
            Assert.assertEquals(expected.get(i), response.get(i));
        }
    }

    @Test
    public void findThePerfectSquareTestsWithNoPerfectSquares() {
        FindThePerfectSquares findTheSquares = new FindThePerfectSquares();
        Integer[] numbers = new Integer[]{33, 22, 33, 234, 55, 2};
        List<Integer> response = findTheSquares.findEvenSquares(numbers);
        Assert.assertEquals(0, response.size());
    }

}
