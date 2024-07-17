package com.ds;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls {

    private static Deque<Integer> requests;

    public NumberOfRecentCalls() {
        requests = new ArrayDeque<>();

    }

    public static int ping(int t) {
        while (!requests.isEmpty() && t - requests.peek() > 3000) {
            requests.poll();
        }
        requests.offer(t);
        return requests.size();
    }

    public static void main(String[] args) {
        NumberOfRecentCalls counter = new NumberOfRecentCalls();
        System.out.println(counter.ping(1)); // Output: 1
        System.out.println(counter.ping(100)); // Output: 2
        System.out.println(counter.ping(3001)); // Output: 3
        System.out.println(counter.ping(3002)); //
    }



}
