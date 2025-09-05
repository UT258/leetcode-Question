/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null || (root.left==null && root.right==null))
        {
            return root;
        }
        Queue<Node> q=new LinkedList<>();
 
        q.offer(root.left);
        q.offer(root.right);
        //there will be no  right for the root node

         
        while(!q.isEmpty())
        {
          int level=q.size();
          Node prev=null;
          for(int i=0;i<level;i++){
            Node current=q.poll();
            if(prev!=null){
                prev.next=current;
            }
            prev=current;
            //now add the childern 
            if(current.left!=null){
                q.offer(current.left);
            }
            if(current.right!=null){
                q.offer(current.right);
            }

          }          
        }
        return root;
        
    }
}