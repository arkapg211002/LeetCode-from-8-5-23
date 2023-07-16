class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(),result = dummy;
        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) 
        {
            sum = carry;  
            if (l1 != null) 
            { 
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) 
            {
                sum += l2.val;
                l2 = l2.next;
            }
			dummy.next = new ListNode(sum%10);
            carry = sum/10;
            dummy = dummy.next;
        }
        if (carry > 0) dummy.next = new ListNode(carry);
        return result.next;
    }
}