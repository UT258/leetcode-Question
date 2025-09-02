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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)
        {
            return false;
        }
        q.offer(root);
        boolean seen=false;
        while(!q.isEmpty())
        {
            TreeNode current=q.poll();
            if(current==null)
            {
                seen=true;
            }
            else{
                if(seen)
                {
                    return false;
                }
                q.offer(current.left);
                q.offer(current.right);
            }
        }
        return true;

    }
}