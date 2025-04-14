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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root==null)
            return answer;
        else
            queue.offer(root);
        double levelSize = 0;
        double sum = 0;
        while (!queue.isEmpty()) {
            answer.add(queue.getLast().val);
            levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offerLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offerLast(currentNode.right);
                }
            }
        }
        return answer;
    }
}