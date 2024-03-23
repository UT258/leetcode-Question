/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode>list =new ArrayList<>();
        
        ListNode node =head;
        while(node!=null)
        {
            list.add(node);
            node=node.next;
        }
    //now check the palindrone  and 
    for(int i=0;i<list.size();i++)
    {
        if (list.get(i).val!=list.get(list.size()-1-i).val)
        {
            return false;
        }
    }
    return true;
        
    }
}