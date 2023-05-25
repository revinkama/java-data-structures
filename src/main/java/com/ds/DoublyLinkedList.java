package com.ds;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.previous = tail;
        tail = newNode;
        length++;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void printElementsForwards() {
        if (head == null) {
            return;
        }

        ListNode temp = head;
        System.out.println("Printing Elements Forwards: ");
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void printElementsBackwards() {
        if (tail == null) {
            return;
        }
        ListNode temp = tail;
        System.out.println("Printing Element Backwards: ");
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.print("null");
        System.out.println();
    }

    public ListNode deleteTheFirstNode() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteTheLastNode() {
        if (isEmpty()) throw new NoSuchElementException();
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);
        dll.insertLast(20);

        dll.printElementsForwards();
        dll.printElementsBackwards();

        System.out.println("\nInserting a Value(13) to Beginning of List: ");
        dll.insertFirst(13);
        dll.printElementsForwards();
        dll.printElementsBackwards();

        System.out.println("\nRemoving First Element");
        dll.deleteTheFirstNode();
        dll.printElementsForwards();

        System.out.println("\nRemoving Last Element");
        dll.deleteTheLastNode();
        dll.printElementsForwards();
    }

}
