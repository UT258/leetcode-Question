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
        //implementaion probelm
        TreeNode current =root;
        while(current!=null)
        {
            //put the remainging in the left subtree where is no right
            if(current.left!=null)
            {
                TreeNode temp=current.left;
                while(temp.right!=null)
            {
                temp=temp.right;
            }

            
            
            //here i will get the right most in lT
            temp.right=current.right;
            current.right=current.left;
            //and now connect the remainging
            current.left=null;
            }
            current=current.right;

        }
        
    }
}