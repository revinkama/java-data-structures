package com.ds;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationsOfAString {

    public static List<String> generatePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        int n = input.length();

        if (n < 3) {
            return permutations;
        }

        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char charI = input.charAt(i);
            if (seen.contains(charI)) {
                continue;
            }
            seen.add(charI);

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                char charJ = input.charAt(j);

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    char charK = input.charAt(k);
                    permutations.add("" + charI + charJ + charK);
                }
            }
            seen.clear();
        }

        return permutations;
    }

    private static boolean isUnique(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.add(c)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String input = "healthcare";
        List<String> result = generatePermutations(input);
        Set<String> setResult = generatePermutationsStream(input);
        int count = 0;
        for (String permutation : result) {
            System.out.println(permutation);
            count++;
        }

        int streamCount = 0;
        for (String permutation : setResult) {
            if (permutation.equals("hth") || permutation.equals("haa")) {
                System.out.println("NOT RIGHTTTT");
            }
            System.out.println(permutation);
            streamCount++;
        }

        System.out.println("Total Count: " + count);
        System.out.println("Total Count: " + streamCount);


        int[] nums = {5, 6, 9, 12, 15};
        int[] finalResult = productExceptSelf(nums);

        for (int num : finalResult) {
            System.out.print(num + " ");
        }

    }

    public static Set<String> generatePermutationsStream(String input) {
        return IntStream.range(0, input.length())
                .boxed()
                .flatMap(i -> IntStream.range(1, input.length())
                        .boxed()
                        .flatMap(j -> IntStream.range(2, input.length())
                                .filter(k -> input.charAt(i) != input.charAt(j) && input.charAt(i) != input.charAt(k) && input.charAt(j) != input.charAt(k))
                                .mapToObj(k -> "" + input.charAt(i) + input.charAt(j) + input.charAt(k))))
                .collect(Collectors.toCollection(HashSet::new));
    }


    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }



}
