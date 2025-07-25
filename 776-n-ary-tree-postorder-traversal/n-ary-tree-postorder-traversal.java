/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void dfs(ArrayList<Integer>list,Node root)
    {
        if(root==null)

        {
            return;
        }
        for(Node child:root.children)
        {
        dfs(list,child);
        }
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        ArrayList<Integer>list=new ArrayList<>();
        dfs(list,root);
        return list;
        
    }
}