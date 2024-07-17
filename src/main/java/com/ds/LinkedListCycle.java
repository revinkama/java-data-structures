package com.ds;

import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycle {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
          next = null;
      }
  }

  // Linked List Cycle 1 O(n)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode turtle = head;
        ListNode rabbit = head;

        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) return true;
        }

        return false;
    }

    // Linked List Cycle II O(1)
    public static boolean hasCycleOptimized(ListNode head) {
        if (head == null || head.next == null) return false;

        HashSet<ListNode> nodesVisited = new HashSet<>();

        ListNode current = head;

        while (current != null) {
            if (nodesVisited.contains(current)) return true;
            nodesVisited.add(current);
            current = current.next;
        }

        return false;
    }

    // Linked List Cycle II O(n)
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode turtle = head;
        ListNode rabbit = head;

        while (rabbit != null && rabbit.next != null) {
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if (turtle == rabbit) break;
        }

        if (rabbit == null || rabbit.next == null) {
            return null;
        }

        turtle = head;
        while (turtle != rabbit) {
            turtle = turtle.next;
            rabbit = rabbit.next;
        }
        return turtle;
    }

    // Linked List Cycle II O(1)
    public static ListNode detectCycleOptimized(ListNode head) {
        if (head == null || head.next == null) return null;

        HashSet<ListNode> nodesVisited = new HashSet<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            if (nodesVisited.contains(currentNode)) {
                return currentNode;
            }
            nodesVisited.add(currentNode);
            currentNode = currentNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        boolean hasCycle = hasCycle(head);

        if (hasCycle) {
            System.out.println("The linked list has a cycle.");
        } else {
            System.out.println("The linked list does not have a cycle.");
        }

        System.out.println(hasCycleOptimized(head));

        System.out.println(detectCycle(head) != null ? detectCycle(head).val : null);
        System.out.println(detectCycleOptimized(head) != null ? detectCycleOptimized(head).val : null);

    }

}
