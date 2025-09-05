/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        {
            return null;

        }
        if(root==p || root==q)
        {
            return root;//found one root

        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //if i have left and right both then i have both p and q then the current node is the common ancestor 
        if(left!=null && right!=null)
        {
            return root;
        }
        
        return left==null?right:left;
        
    }
}