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
    List<Integer>list =new ArrayList<>();
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
      postorder(root);
      return list;
    }
    public void postorder(TreeNode node)
    {
        if (node==null)
        {
            
            return;
        }
        postorder(node.left);
        postorder(node.right);
        list.add(node.val);
    }

}