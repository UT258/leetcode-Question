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
    public boolean isCousins(TreeNode root, int x, int y) {
        //the node will be cousin if they are not sibling and at the same 
        //level
        if(root==null)
        {
            return false;
        }
        TreeNode x1=findNode(root,x);
        TreeNode y1=findNode(root,y);
        if(level(root,x1,0)==level(root,y1,0) && (!isSibling(root,x1,y1)))
        {
            return true;
        }
        return false;
    }
    TreeNode findNode(TreeNode node,int val)
    {
        if(node==null)
        {
            return null;//does not exist

        }
        if(node.val==val)
        {
            return node;
        }
        TreeNode left=findNode(node.left,val);//search in the left tree
        if(left!=null)
        {
        //if the node is not null means the element is present
        return left;
        }
        return findNode(node.right,val);//search in the right half
    }

    public boolean isSibling(TreeNode node,TreeNode x,TreeNode y)
    {
        //they are siblings if they are from same parent
        if(node==null)
        {
            return false; 
        }
        if(node.left == x  && node.right==y || node.left == y  && node.right==x)
        {
            return true;
        
        }
        boolean left=isSibling(node.left,x,y);
        if(left)
        {
            return true;
        }
        return isSibling(node.right,x,y);
        


    }
    public int level(TreeNode node,TreeNode x,int lev)
    {
        if(node==null)
        {
            return 0;
        }
        if(node==x)
        {
            return lev;
        }
        int l=level(node.left,x,lev+1);
        if(l!=0)
        {
            return l;
        }
        return level(node.right,x,lev+1);
    }
}