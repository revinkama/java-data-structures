package com.amigoscode;

import javax.sound.midi.Soundbank;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void displayElements() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public int lengthOfSinglyLinkedList() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertFirst(int value) {
        ListNode listNode = new ListNode(value);
        listNode.next = head;
        head = listNode;
    }

    public void insertLast(int value) {
        ListNode listNode = new ListNode(value);
        if (head == null) {
            head = listNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = listNode;
    }

    public void insertAtIndex(int value, int index) {
        ListNode listNode = new ListNode(value);
        if (index == 1) {
            listNode.next = head;
            head = listNode;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < index - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            listNode.next = current;
            previous.next = listNode;
        }
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public void deleteAtIndex(int index) {
        // position is valid and starts at 1
        if (index == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < index - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    public boolean searchForElement(int key) {
        ListNode current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public ListNode reverseSinglyLinkedList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode middleNodeOfList() {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode findNodeAtIndex(int index) {
        if (head == null) {
            return null;
        }

        ListNode main = head;
        ListNode ref = head;
        int count = 0;
        while (count < index) {
            ref = ref.next;
            count++;
        }
        while (ref != null) {
            ref = ref.next;
            main = main.next;
        }
        return main;
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public ListNode addingToSortedList(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) return newNode;
        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;

    }

    public void removingFromListByKey(int value) {
        ListNode current = head;
        if (current != null && current.data == value) {
            head = current.next;
            return;
        }

        ListNode temp = null;
        while (current != null && current.data != value) {
            temp = current;
            current = current.next;
        }
        if(current == null) {return;}
        temp.next = current.next;
    }

    public static ListNode mergeSortedLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return dummy.next;
    }

    public static ListNode addTwoLinkedLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a!=null || b!=null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//        ListNode fifth = new ListNode(1);
//
//        //Now form the chain
//        sll.head.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;

//        sll.displayElements();
//        System.out.println("Length of Linked List: " + sll.lengthOfSinglyLinkedList());
//
//        System.out.println("Insert Node to beginning of list:");
//        sll.insertFirst(133);
//        sll.displayElements();
//
//        System.out.println("Insert Node to end of list:");
//        sll.insertLast(123);
//        sll.displayElements();
//
//        System.out.println("Inserting value to an index: ");
//        sll.insertAtIndex(3, 2);
//        sll.displayElements();
//        sll.insertAtIndex(144, 1);
//        sll.displayElements();

//        System.out.println();
//        System.out.println("Deleting First Node: ");
//        sll.deleteFirst();
//        sll.displayElements();
//        System.out.println();
//
//        System.out.println("Deleting Last Node: ");
//        sll.deleteLast();
//        sll.displayElements();
//        System.out.println();
//
//        System.out.println("Deleting Node at Index (1): ");
//        sll.deleteAtIndex(1);
//        sll.displayElements();
//        System.out.println();
//
//        System.out.println("Deleting Node at Index (3): ");
//        sll.deleteAtIndex(3);
//        sll.displayElements();
//        System.out.println();
//
//        System.out.println("Searching For Element (11): " + sll.searchForElement(11));
//        System.out.println("Searching For Element (123): " + sll.searchForElement(123));
//
//        System.out.println("Reversing Singly Linked List: ");
//        sll.reverseSinglyLinkedList(sll.head);
//        sll.displayElements();
//
//        System.out.println("Middle Node: " + sll.middleNodeOfList().data);
//        System.out.println("Node at index(3) from end: " + sll.findNodeAtIndex(3).data);


//        System.out.println("Before Removing Duplicates");
//        sll.displayElements();
//        System.out.println("After Removing Duplicates");
//        sll.removeDuplicates();
//        sll.displayElements();
//
//        System.out.println("Inserting into sorted List(6):");
//        sll.addingToSortedList(6);
//        sll.displayElements();
//
//        System.out.println("Removing key 5: ");
//        sll.removingFromListByKey(5);
//        sll.displayElements();

        sll.insertFirst(9);
        sll.insertFirst(4);
        sll.insertFirst(7);
//        sll.insertFirst(2);
//        sll.insertFirst(1);
//        System.out.println("First Sorted List: ");
        sll.displayElements();

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertFirst(6);
        sll2.insertFirst(5);
//        System.out.println("Second Sorted List: ");
        sll2.displayElements();
//
//        SinglyLinkedList result = new SinglyLinkedList();
//        result.head = mergeSortedLists(sll.head, sll2.head);
//        System.out.println("Sorted Both Lists: ");
//        result.displayElements();

        System.out.println("Adding both lists: ");
        SinglyLinkedList result2 = new SinglyLinkedList();
        result2.head = addTwoLinkedLists(sll.head, sll2.head);
        result2.displayElements();
    }

}


