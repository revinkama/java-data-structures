package com.ds;

public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    // Add two numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // [2, 4, 3]
        // [5, 6, 4]
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(deleteDuplicates(head).val);

        ListNode atHead = new ListNode(2);
        ListNode atNode = new ListNode(4);
        ListNode atNode2 = new ListNode(3);
        atHead.next = atNode;
        atNode.next = atNode2;
        ListNode atHead2 = new ListNode(5);
        ListNode atNode3 = new ListNode(6);
        ListNode atNode4 = new ListNode(4);
        atHead2.next = atNode3;
        atNode3.next = atNode4;

    }

}
