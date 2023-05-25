package com.ds;

import java.util.Stack;

public class BinaryTreeExamples {

    private TreeNode root;

    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
    }

    public void preOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public void preOrderIterative() {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public void inOrderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRecursive(root.left);
        System.out.print(root.data + " ");
        inOrderRecursive(root.right);
    }

    public void inOrderIterative() {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    public void postOrderRecursive(TreeNode root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrderIterative() {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.println(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }

    public int findMaxRecursive(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMaxRecursive(root.left);
        int right = findMaxRecursive(root.right);
        if (left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeExamples binaryTreeExamples = new BinaryTreeExamples();
        binaryTreeExamples.createBinaryTree();
        binaryTreeExamples.preOrderIterative();
        System.out.println();
        System.out.println("Recursive In Order: ");
        binaryTreeExamples.inOrderRecursive(binaryTreeExamples.root);
        System.out.println();
        System.out.println("Iterative In Order: ");
        binaryTreeExamples.inOrderIterative();
        System.out.println();
        System.out.println("Recursive Post Order: ");
        binaryTreeExamples.postOrderRecursive(binaryTreeExamples.root);

        System.out.println();
        System.out.println("Recursive Find Max: ");
        System.out.println(binaryTreeExamples.findMaxRecursive(binaryTreeExamples.root));

        System.out.println();
        System.out.println("Insert Into Tree: (8)");
        binaryTreeExamples.insert(binaryTreeExamples.root, 8);
        binaryTreeExamples.inOrderIterative();
    }

}
