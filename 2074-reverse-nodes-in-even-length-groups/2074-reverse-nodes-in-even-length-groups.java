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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        if(head == null) return head;

        int groupSize = 1;
        int count = 0;
        ListNode left = null;
        ListNode ptr = head;
        ListNode last = null;
        
        while(ptr != null) {
            count++;
            if(count == groupSize) {
                if(groupSize  % 2 == 0) {
                    ListNode end = ptr.next;
                   // reverse
                    ListNode cur = left;
                    ListNode next = null;
                    ListNode prev = ptr.next;
                    while(cur != end) {
                        next = cur.next;
                        cur.next = prev;
                        prev = cur;
                        cur = next;
                    }
                    // connect
                    last.next = prev;
                    ptr = left;
                   
                }
                last = ptr;
                left = ptr.next;
                count = 0;
                groupSize++;
            }
            ptr = ptr.next;
        }

        if(count > 0 && count % 2 == 0) {
            // reverse
            ListNode cur = left;
            ListNode next = null;
            ListNode prev = ptr;

            while(cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            last.next = prev;
        }

        return head;
    }

}