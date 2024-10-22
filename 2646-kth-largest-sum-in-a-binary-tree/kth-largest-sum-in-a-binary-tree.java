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
     public List<Long> levelOrder(TreeNode root) {
        List<Long> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0; // Calculate sum as a long to handle large sums
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();

                // Add children to the queue
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }

                // Add current node's value to the sum
                sum += current.val;
            }

            result.add(sum); // Add the level sum to the result
        }
        return result; 
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        // Perform level order traversal and collect the sums of each level
        List<Long> list = levelOrder(root);

        // Sort the sums in ascending order
        Collections.sort(list);

        // If there are fewer than k levels, return -1
        if (list.size() < k) {
            return -1;
        }

        // Return the kth largest sum (i.e., the (size - k)th in a sorted list)
        return list.get(list.size() - k);
    }
}
