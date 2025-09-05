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
    int c=0;
    public int kthSmallest(TreeNode root, int k) {
        return solve(root,k).val;
        
    }
    private TreeNode solve(TreeNode root,int k)
    {
        if(root==null)
        {
            return null;
        }
        TreeNode left=solve(root.left,k);
        if(left!=null)
        {
            return left;
        }
        c++;
        if(c==k){
            return root;
        }
        return solve(root.right,k);
    }
}