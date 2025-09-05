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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans =new ArrayList<>();
        //apply level order traversal 
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int len=q.size();
            double sum=0;
            for(int i=0;i<len;i++)
            {
                TreeNode current= q.poll();
                 sum+=current.val;
                 if(current.left!=null)
                 {
                    q.offer(current.left);
                 }
                 if(current.right!=null){
                    q.offer(current.right);
                 }
             
            }
            //no here i have the level sum
            ans.add(sum/len);
        }
        return ans;

        
    }
}