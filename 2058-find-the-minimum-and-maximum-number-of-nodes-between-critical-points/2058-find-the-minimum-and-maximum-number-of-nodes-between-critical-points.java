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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res={-1,-1};
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode nextNode=curr.next;

        if(prev==null || curr==null || nextNode==null){
            return res;
        }
        int ct=1;
        List<Integer> list=new ArrayList<>();

        while(nextNode!=null){
            int prevValue=prev.val;
            int currValue=curr.val;
            int nextValue=nextNode.val;

            ct++;
            if((currValue>prevValue && currValue>nextValue) || (currValue<prevValue && currValue<nextValue) ){
                list.add(ct);
            }
            prev=curr;
            curr=nextNode;
            nextNode=nextNode.next;
        }

        int len=list.size();
        if(len<2){
            return res;
        }
        if(len==2){
            res[0]=list.get(1)-list.get(0);
            res[1]=list.get(1)-list.get(0);
        }
        else{
            res[0]=list.get(1)-list.get(0);
            for(int i=2;i<len;i++){
                res[0]=Math.min(res[0],list.get(i)-list.get(i-1));
            }
            res[1]=list.get(len-1)-list.get(0);
        }
        return res;

    }
}