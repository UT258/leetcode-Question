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
    public int getDecimalValue(ListNode head) {
        int sum=0;
        int size=size(head)-1;
        while(head!=null)
        {
          sum+=head.val*(int)Math.pow(2,size);
          head=head.next;
          size--;
        }
        return sum;
        
    }
    public int size(ListNode head)
    {
         int size=0;
         ListNode node =head;
         while(node!=null)
         {
            size++;
            node =node.next; 
         }
         return size;
    }
}