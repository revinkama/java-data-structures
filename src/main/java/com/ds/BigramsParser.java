package com.ds;

import java.util.ArrayList;
import java.util.List;

public class BigramsParser {
    public static List<String> generateBigrams(String input) {
        List<String> bigrams = new ArrayList<>();

        // Split the input string into words
        String[] words = input.split(" ");

        // Generate bigrams
        for (int i = 0; i < words.length - 1; i++) {
            bigrams.add(words[i] + " " + words[i + 1]);
        }

        return bigrams;
    }

    public static void main(String[] args) {
        // Sample input
        String input = "This is a simple example for generating bigrams";

        // Generate bigrams
        List<String> bigrams = generateBigrams(input);

        // Print bigrams
        for (String bigram : bigrams) {
            System.out.println(bigram);
        }
    }
}
