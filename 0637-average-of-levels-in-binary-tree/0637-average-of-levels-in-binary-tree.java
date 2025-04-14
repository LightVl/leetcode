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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new ArrayList<>(); // Stores the averages of each level
        Deque<TreeNode> queue = new ArrayDeque<>(); // Queue for traversing the tree level by level
        queue.offer(root); // Start with the root
      
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes in the current level
            long sum = 0; // Sum of values of nodes in the current level
            // Iterate over all nodes in the current level
            for (int i = 0; i < levelSize; ++i) {
                TreeNode currentNode = queue.pollFirst(); // Get and remove the node from the queue
                sum += currentNode.val; // Add the node's value to the sum
                // Enqueue child nodes for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            averages.add((double)sum / levelSize); // Compute and add the average for this level to the result
        }
        return averages; // Return the list of averages
    }    
}