package com.amigoscode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindTheSquareTests {
    @Test
    public void findTheSquareTests() {
        FindTheSquares findTheSquares = new FindTheSquares();
        Integer[] numbers = new Integer[]{1, 33, 4, 16, 9, 55, 2};
        List<Integer> expected = new ArrayList<>();
        List<Integer> response = findTheSquares.findEvenSquares(numbers);
        expected.add(1);
        expected.add(4);
        expected.add(16);
        expected.add(9);
        Assert.assertEquals(4, response.size());
        for (int i = 0; i < response.size(); i++) {
            Assert.assertEquals(expected.get(i), response.get(i));
        }
    }

    @Test
    public void findTheSquareTestsNegativeScenarios() {
        FindTheSquares findTheSquares = new FindTheSquares();
        Integer[] numbers = new Integer[]{1, 33, 4, 16, 9, 55, 2};
        List<Integer> expected = new ArrayList<>();
        List<Integer> response = findTheSquares.findEvenSquares(numbers);
        expected.add(1);
        expected.add(4);
        expected.add(16);
        expected.add(9);
        for (int i = 0; i < response.size(); i++) {
            if (Objects.equals(expected.get(i), response.get(i))) {
                continue;
            }
            else Assert.assertNotEquals(expected.get(i), response.get(i));
        }
    }

}
