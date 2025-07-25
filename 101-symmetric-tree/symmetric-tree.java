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
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left,root.right);
        
    }
    public boolean solve(TreeNode l,TreeNode r)
    {   //basic case when there are only two nodes
        if(l==null && r==null)
        {
            return true;
        }
        if(l==null || r==null)
        {
            return false;
        }
        
        if(l.val!=r.val)
        {
            return false;
        }
    return solve(l.left,r.right)  && solve(l.right,r.left);
    
        
    }
}