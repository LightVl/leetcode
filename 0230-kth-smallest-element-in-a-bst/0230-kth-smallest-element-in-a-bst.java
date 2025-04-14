/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrder(root, list);
        Collections.sort(list);
        //int answer = 100000;
        //for (int i = 1; i < list.size(); i++)
            //answer = Math.min(answer, list.get(i) - list.get(i - 1));
        return list.get(k-1);
    }

    private void preOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);    
    }
}