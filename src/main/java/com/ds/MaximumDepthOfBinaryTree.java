package com.ds;

import com.sun.source.tree.Tree;

public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int maxDepth = maxDepth(root);
        System.out.println("Max Depth of Binary Tree: " + maxDepth);

        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);

        boolean isValid = isValidBST(root);
        System.out.println("Is Valid BST: " + isValid);
    }

    public static int maxDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;

        int leftDepth = maxDepth(treeNode.left);
        int rightDepth = maxDepth(treeNode.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static boolean isValidBST(TreeNode treeNode) {
        return isValidBST(treeNode, null, null);
    }

    private static boolean isValidBST(TreeNode treeNode, Integer low, Integer high) {

        if (treeNode == null) return true;

        int val = treeNode.val;

        if ((low != null && val <= low) || (high != null && val >= high)) {
            return false;
        }

        return isValidBST(treeNode.left, low, val) && isValidBST(treeNode.right, val, high);

    }


}
