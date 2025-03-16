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
    public int maxDepth(TreeNode root) {
        return solve(root,0);//starting from root marking it 1
        
    }
    public int solve(TreeNode root,int level)
    {
        if(root==null)
        {
            return level;//you reached the end
        }
        int left=solve(root.left,level+1);
        int right=solve(root.right,level+ 1);//go to depth in the right substree
        return Math.max(left,right);
    }
}