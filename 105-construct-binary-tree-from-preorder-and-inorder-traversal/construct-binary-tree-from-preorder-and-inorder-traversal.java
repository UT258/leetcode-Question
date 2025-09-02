class Solution {
    private int preIndex = 0; // tracks index in preorder array
    
    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        
        int val = preorder[preIndex++];
        int i = start;
        while (i <= end) {
            if (inorder[i] == val) break;
            i++;
        }
        
        TreeNode root = new TreeNode(val);
        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, preorder.length - 1);
    }
}
