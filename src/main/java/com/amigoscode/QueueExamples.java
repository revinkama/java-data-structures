package com.amigoscode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueExamples {

    private ListNode front;
    private ListNode rear;
    private int length;

    public QueueExamples() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int getLength() { return length; }
    public boolean isEmpty() { return length == 0;}
    public void print() {
        if (isEmpty()) return;
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
    }

    public void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int result = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        length--;
        return result;
    }

    public String[] generateBinaryNumbers(int n) {
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return result;
    }

    public static void main(String[] args) {
        QueueExamples queueExamples = new QueueExamples();
        System.out.println("Adding to queue");
        queueExamples.enqueue(10);
        queueExamples.enqueue(15);
        queueExamples.enqueue(20);
        queueExamples.print();
        System.out.println();

        queueExamples.dequeue();
        System.out.println("Removing from queue");
        queueExamples.print();

        System.out.println();
        System.out.println("Printing Binary Numbers from 5 input: ");
        Arrays.stream(queueExamples.generateBinaryNumbers(5)).forEach(string -> System.out.println(string));
    }
}
