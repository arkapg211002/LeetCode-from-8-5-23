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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = null, temp = head;
        while (temp != null) {
            if (prev != null) {
                ListNode gcd = new ListNode(gcd(prev.val, temp.val));
                prev.next = gcd;
                gcd.next = temp;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}