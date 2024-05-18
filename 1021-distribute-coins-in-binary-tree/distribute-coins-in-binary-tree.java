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
    public static int solve(TreeNode root, int [] moves)
    {
        if (root==null)
        {
            return 0;
        }

        
        int l=solve(root.left,moves);
        int r=solve(root.right,moves);
        moves[0]+=Math.abs(l)+Math.abs(r);
        return  (l+r+root.val)-1;
    }
    public int distributeCoins(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
        {
            return 0;
        }
        
        int moves[]={0};
        //need to use array so refrence so change in the moves get reflected
        
        solve(root,moves);
        

        return moves[0];
    }
}