class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if( k == 0 || head ==null || head.next == null) return head;

        int len=1;
        ListNode cur=head;
        //count and travel to the last node;
        while(cur.next != null){
            len++;
            cur=cur.next;
        }
        //when k=len we get the same linked list
        k = len - (k%len);
        //make a loop by attaching last to first
        cur.next = head;

        while(k > 0){
            cur=cur.next;
            k--;
        } 
        //get the head and break the link
        head = cur.next;
        cur.next = null;

        return head;

    }
}