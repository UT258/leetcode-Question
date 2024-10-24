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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
         if (root1 == null && root2 == null) return true;
        
        // If one is null but the other is not, they aren't equivalent
        if (root1 == null || root2 == null) return false;
        
        // If the values don't match, they aren't equivalent
        if (root1.val != root2.val) return false;
        
        // Check both the normal and flipped conditions recursively
        boolean normal = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flipped = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        // Return true if either the normal or flipped condition holds
        return normal || flipped;
    }
}