/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // take two pointer
        // if the size is less than 1 you cannot find the gcd
        if (head == null || head.next == null) {
            return head;
        }
        ListNode f = head;
        ListNode s = head.next;

        while ( s != null) {
            // create a node with gcd
            int val=gcd(f.val, s.val);
            ListNode gcdNode = new ListNode(val);
            // now connect f with gcd
            f.next = gcdNode;
            // gcd should be in between the gcd next should be s
            gcdNode.next = s;
            // now move the pointer
            f = s;
            s = s.next;

        }
        return head;

    }

    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}