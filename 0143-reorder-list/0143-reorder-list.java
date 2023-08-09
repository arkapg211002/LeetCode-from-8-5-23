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
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;
        int n = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode c = head;
        while (c != null) 
        {
            stack.push(c);
            c = c.next;
            n++;
        }
        c = head;
        for (int i = 0; i < n / 2; i++) 
        {
            ListNode temp = c.next;
            c.next = stack.pop();
            c.next.next = temp;
            c = c.next.next;
        }
        if (n % 2 == 1) 
        {
            c.next = stack.pop();
            c = c.next;
        }
        c.next = null;
    }
}