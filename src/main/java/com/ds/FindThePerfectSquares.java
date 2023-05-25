package com.ds;

import java.util.*;
import java.util.stream.Collectors;

public class FindThePerfectSquares {

    public List<Integer> findEvenSquares(Integer[] numbers) {
        return Arrays.stream(numbers).filter(num -> {
            double sqrt = Math.sqrt(num);
            return (sqrt - Math.floor(sqrt)) == 0;
        }).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        FindThePerfectSquares findTheSquares = new FindThePerfectSquares();
        Integer[] numbers = new Integer[]{1, 33, 4, 16, 9, 55, 2};
        findTheSquares.findEvenSquares(numbers).forEach(System.out::println);
    }

}
