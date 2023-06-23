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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode newhead=new ListNode(-1);
        ListNode prev=newhead;
        ListNode curr=head;
        ListNode next=head.next;
        if(curr.val!=next.val){
            prev.next=curr;
            prev=curr;
        }
        while(next!=null){
            if(curr.val==next.val){
                curr=curr.next;
                next=next.next;continue;
            }
            else{
                curr=curr.next;
                next=next.next;
                if(next!=null&&curr.val==next.val)continue;
                prev.next=curr;
                prev=curr;
            }
        }
        prev.next=next;
        return newhead.next;
    }
}