public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fp = head, sp = head;
        while(fp != null && fp.next != null){
            fp = fp.next.next;
            sp = sp.next;
            if(fp == sp) return true;
        }
        return false;
    }
}