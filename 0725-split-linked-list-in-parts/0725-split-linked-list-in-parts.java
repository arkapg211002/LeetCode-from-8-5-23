class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        ListNode curr = head;
        int length = 0;
        // find the total length of the linked list 
        while(curr!=null)
        {
            curr = curr.next;
            length++;
        }
          int rem =0;
          
        // if condition to handle edge cases
          if(length>=k)
          rem =  length %k;
        
        // find the length of subparts we need to divide it into 
         int cutLength =  length/k;
        
        // again starting from head 
        curr = head;
        ListNode arr[] = new ListNode[k];
        ListNode temp = curr;
        int len =0;
        // x to check when we reach k
        int x =0;
        while(curr!=null )
        {
            len = rem>0?cutLength + 1:cutLength;
            // remember to decrement rem as we are using 1 from rem always for each subarray length 
            rem = rem-1;
            // reach till the end 
            while(curr.next!= null && len-->1)
            {
                curr =  curr.next;
             
            }
           
              //System.out.print(curr.val + " ");
            // save the new head
            ListNode newHead =  curr.next;
            curr.next = null;
            // store the curr subarray to the result
            arr[x] = temp;
            // move to the next subarray 
            temp =  newHead;
            curr = newHead;
            x++;
        }
        
        //System.out.print(length);
        return arr;
    }
}