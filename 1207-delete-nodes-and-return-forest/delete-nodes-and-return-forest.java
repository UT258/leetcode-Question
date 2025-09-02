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
    Set<Integer>set=new HashSet<>();
    List<TreeNode>ans=new ArrayList<>();
    private  TreeNode solve(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        root.left=solve(root.left);
        root.right=solve(root.right);

        if(set.contains(root.val))
        {
            //then it is to be delete but we have to add it before 
            if(root.left!=null)
            {
                ans.add(root.left);
                
            }
            if(root.right!=null)
            {
                ans.add(root.right);
            }
            //now to delete 
            return null;

        }
        else{
            //if dont need to remove just return the root itself\
            return root;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //you have to delete a node
      //make a set we need to remove the node
      //we will go botom up 
      //cuz if we go top to down if you remove a node while traversing and there is another 
      //node after it that is needed to be removed 
      //then you will not able to reach that node

      for(int n:to_delete)
      {
        set.add(n);

      }
       
     root=  solve(root); 
       //now add for the root if we need to remove the root as well
       if(root!=null)
       {
        ans.add(root);
       }
       return ans;

        
    }
}