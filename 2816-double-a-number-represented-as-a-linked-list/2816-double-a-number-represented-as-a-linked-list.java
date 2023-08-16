class Solution {
    public ListNode doubleIt(ListNode head) {
        List<Integer> nm=new ArrayList<>();
        for(ListNode ptr=head;ptr!=null;ptr=ptr.next)
        {
            nm.add(ptr.val);
        }
        List<Integer> kk=new ArrayList<>();
        int size=nm.size();
        int carry=0;
        for(int i=size-1;i>=0;i--)
        {
            int sum=nm.get(i)*2;
            sum+=carry;
            if(sum>=10)
            {
                kk.add(0, sum-10);
                carry=1;
            }
            else
            {
                kk.add(0,sum);
                carry=0;
            }
        }
        if(carry!=0)
        {
            kk.add(0,carry);
        }
        ListNode start=null,prev=null,fresh;
        for(int i=0;i<kk.size();i++)
        {
            fresh=new ListNode(kk.get(i));
            if(start==null)
            {
                start=fresh;
            }
            else
            {
                prev.next=fresh;
            }
            prev=fresh;
        }
        return start;
    }
}