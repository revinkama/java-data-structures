package com.amigoscode;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheSquares {

    public List<Integer> findEvenSquares(Integer[] numbers) {
        return Arrays.stream(numbers).filter(num -> {
            double sqrt = Math.sqrt(num);
            return (sqrt - Math.floor(sqrt)) == 0;
        }).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        FindTheSquares findTheSquares = new FindTheSquares();
        Integer[] numbers = new Integer[]{1, 33, 4, 16, 9, 55, 2};
        findTheSquares.findEvenSquares(numbers).forEach(System.out::println);
    }

}
