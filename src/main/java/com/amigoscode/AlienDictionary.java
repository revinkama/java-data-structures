package com.amigoscode;

import java.util.*;

/*
The Alien Dictionary is a problem where we are given an array of strings words representing a sorted dictionary of an alien language.
The problem is to determine the order of characters in this alien language.

Here's an example Java code for Alien Dictionary:
 */

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        buildGraph(words, graph, indegree);
        return bfs(graph, indegree);
    }

    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        indegree[c2 - 'a']++;
                    }
                    break;
                }
            }
        }
    }

    private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : graph.get(c)) {
                indegree[neighbor - 'a']--;
                if (indegree[neighbor - 'a'] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (sb.length() != graph.size()) {
            return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary ad = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String order = ad.alienOrder(words);
        System.out.println(order);
    }
}
