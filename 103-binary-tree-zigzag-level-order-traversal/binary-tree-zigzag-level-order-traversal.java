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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;//return empty list 
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            //to store the level
            int levelsize = q.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode current = q.poll();
                level.add(current.val);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }

            }
            //add it in the answer
            ans.add(level);
        }
        return ans;

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = levelOrder(root);
        boolean zigzag = false;
        for (List<Integer> temp : ans) {
            if (zigzag)
                Collections.reverse(temp);
            zigzag = !zigzag;
        }
        return ans;
    }
}