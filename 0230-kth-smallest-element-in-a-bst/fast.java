package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode root1 = new TreeNode(7);
        TreeNode root2 = new TreeNode(15);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(9);
        root.left = root1;
        root.right = root2;
        root.left.right = root3;
        root.left.right.right = root4;
        System.out.println(kthSmallest(root,3));
    }
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
        return 0;
    }
}
