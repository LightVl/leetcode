package org.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    private static int minDifference;
    private static int previousValue;
    private static final int INFINITY = Integer.MAX_VALUE;
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
        System.out.println(averageOfLevels(root));
        System.out.println(findRightSideView(root));
        System.out.println(getMinimumDifference(root));
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        double levelSize = 0;
        double sum = 0;
        while(!queue.isEmpty()) {
            levelSize = queue.size();
            for (int i=0;i<levelSize;i++) {
                TreeNode currentNode = queue.poll();
                sum = sum + currentNode.val;
                if(currentNode.left !=null) {
                    queue.offerLast(currentNode.left);
                }
                if(currentNode.right !=null) {
                    queue.offerLast(currentNode.right);
                }
            }
            answer.add(sum/levelSize);
            sum = 0;
        }
        return answer;
    }
    public static List<Integer> findRightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root==null)
            return answer;
        else
            queue.offer(root);
        double levelSize = 0;
        while(!queue.isEmpty()) {
            answer.add(queue.getLast().val);
            levelSize = queue.size();
            for (int i=0;i<levelSize;i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.left !=null) {
                    queue.offerLast(currentNode.left);
                }
                if(currentNode.right !=null) {
                    queue.offerLast(currentNode.right);
                }
            }
        }
        return answer;
    }
    public static int getMinimumDifference(TreeNode root) {
        minDifference = INFINITY;
        previousValue = INFINITY;
        iteration(root);
        return minDifference;
    }
    public static void iteration(TreeNode node) {
        if (node == null) {
            return;
        }
        iteration(node.left);
        if (previousValue != INFINITY) {
            minDifference = Math.min(minDifference, Math.abs(node.val - previousValue));
        }
        previousValue = node.val;
        iteration(node.right);
    }
}
