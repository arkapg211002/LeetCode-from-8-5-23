class Solution {
    ListNode l;
    int max = 0;
    public int pairSum(ListNode head) 
    {
        l = head;
        helper(head);
        return max;
    }
    public int helper(ListNode n) 
    {
        if (n.next == null) return n.val;
        var r = helper(n.next);
        if (r == -1) return r;
        max = Math.max(max, l.val + r);
        l = l.next;
        return l == n ? -1 : n.val; 
    }
}