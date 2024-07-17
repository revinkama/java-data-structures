package com.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfArray {


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        System.out.println(degreeOfArray(arr));
    }

    public static int degreeOfArray(List<Integer> arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            if(map.containsKey(arr.get(i))) {
                map.put(arr.get(i), map.get(arr.get(i)) + 1);
            } else {
                map.put(arr.get(i), 1);
            }
        }
        int largestDegree = 1;
        for (Map.Entry entry : map.entrySet()) {
            int value = (int) entry.getValue();
            if (value > largestDegree) {
                largestDegree = value;
            }
        }
        return largestDegree;
    }

}
