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
    public int[] nextLargerNodes(ListNode head) {
        int n = size(head);
        int arr[] = new int[n];
        ListNode curr = head;
        int i=0;
        while(curr!=null)
        {
            ListNode temp = curr.next;
            while(temp!=null)
            {
                if(temp.val>curr.val)
                    break;
                temp = temp.next;
            }
            if(temp==null)
                arr[i++]=0;
            else
                arr[i++]=temp.val;
            curr = curr.next;
        }
        return arr;
    }
    public int size(ListNode temp)
    {
        int n = 0;
        while(temp!=null){
            temp = temp.next;
            n++;
        }
        return n;
    }
}