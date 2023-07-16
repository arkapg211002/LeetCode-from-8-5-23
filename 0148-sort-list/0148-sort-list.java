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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode mid = middle(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        ListNode temp = new ListNode();
        ListNode ans = temp;

        while (head1 != null && head2 != null)
        {
            if (head1.val <= head2.val) {

                temp.next = new ListNode(head1.val);
                temp = temp.next;
                head1 = head1.next;

            }
            else
            {
                temp.next = new ListNode(head2.val);
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            temp.next = head2;
        }
        else if (head2 == null) {
            temp.next = head1;
        }

        return ans.next;
    }

    public ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}