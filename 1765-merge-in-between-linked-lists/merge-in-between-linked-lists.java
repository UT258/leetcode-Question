class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode n2=list1;
        ListNode a1 = getNode(a - 1, n2);
       // a1.next = list2;
        if(list1==null)
        {
            return null;
        }

        ListNode lastList2Node = list2;
        while (lastList2Node.next != null) {
            lastList2Node = lastList2Node.next;
        }

        ListNode b1 = getNode(b + 1,list1 );
        a1.next=list2;
        lastList2Node.next = b1;
        


        return list1;
    }

    public ListNode getNode(int index, ListNode head) {
        int i = 0;
        ListNode node = head;
        while (node != null) {
            if (i == index) {
                return node;
            }
            i++;
            node = node.next;
        }
        return head;
    }
}
