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
    public void flatten(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left != null) {
                // find the rightmost node of left subtree
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                // connect it to the right subtree
                temp.right = current.right;

                // move left subtree to right
                current.right = current.left;
                current.left = null;
            }

            // move to the next node
            current = current.right;
        }
    }
}
