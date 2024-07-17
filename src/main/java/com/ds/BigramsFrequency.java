package com.ds;

import java.util.HashMap;
import java.util.Map;

public class BigramsFrequency {

    public static Map<String, Integer> generateBigramFrequencies(String input) {
        Map<String, Integer> bigramFrequencies = new HashMap<>();

        // Split the input string into words
        String[] words = input.split("\\s+");

        // Generate bigram frequencies
        for (int i = 0; i < words.length - 1; i++) {
            String bigram = words[i] + " " + words[i + 1];
            bigramFrequencies.put(bigram, bigramFrequencies.getOrDefault(bigram, 0) + 1);
        }

        return bigramFrequencies;
    }

    public static void main(String[] args) {
        // Sample input
        String input = "This is a simple example for generating bigrams. This is a simple test.";

        // Generate bigram frequencies
        Map<String, Integer> bigramFrequencies = generateBigramFrequencies(input);

        // Print bigram frequencies
        for (Map.Entry<String, Integer> entry : bigramFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}