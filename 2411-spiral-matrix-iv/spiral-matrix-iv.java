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
    public int[][] spiralMatrix(int r, int c, ListNode head) {
        int matrix[][]=new int[r][c];
        for(int []arr:matrix)
        {
            Arrays.fill(arr,-1);
        }

        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;
        int idx = 0;
        while (top <= bottom && left <= right &&head!=null)

        {
            // now print the first row
            if (idx == 0) {
                for (int i = left; i <= right && head!=null; i++) {
                    matrix[top][i]=head.val;
                    head=head.next;
                }

                // since first row done move the bootom
                top++;
            }
            // for top to down
            if (idx == 1) {
                for (int i = top; i <= bottom && head!=null; i++) {
                    matrix[i][right]=head.val;
                    head=head.next;//col will be right
                }
                right--;
            }
            // for right to left
            if (idx == 2) {
                // Move left across the bottom row
                for (int i = right; i >= left && head!=null; i--) {
                     matrix[bottom][i]=head.val;
                    head=head.next;
                }
                bottom--;
            }

            if (idx == 3) {
                // Move up the left column
                for (int i = bottom; i >= top && head!=null ; i--) {
                     matrix[i][left]=head.val;
                    head=head.next;
                }
                left++;
            }
            idx++;
            if (idx == 4)

            {
                idx = 0;
            }

        }
        return matrix;

        
    }
}