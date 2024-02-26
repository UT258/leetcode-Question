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
    //aproach is same just do any traversal on both the trees
    //if they are equal then tree is same
    
    public void preorder(TreeNode node,ArrayList<Integer>list)
    {
        if (node==null)
        {   list.add(null);
            return ;
        }
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
    ArrayList<Integer>l1=new ArrayList<>();
    ArrayList<Integer>l2=new ArrayList<>();
    preorder(p,l1);
    preorder(q,l2);
    return l1.equals(l2);
    
        
    }
}