class Pair
{
    int val, ind;
    Pair(int val, int ind)
    {
        this.val=val;
        this.ind=ind;
    }
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[]=new int[nums.length-k+1];
        PriorityQueue<Pair>q=new PriorityQueue<Pair>(new Comparator<Pair>()
            {
                @Override
                public int compare(Pair a, Pair b)
                {
                    if(a.val>b.val) return -1;
                    else if(a.val<b.val) return 1;
                    else return 1;
                }
            });
        for(int i=0;i<k;i++)
            q.add(new Pair(nums[i],i));
        ans[0]=q.peek().val;
        int j=1;
        for(int i=k;i<nums.length;i++)
        {
            q.add(new Pair(nums[i],i));
            while(q.peek().ind<=i-k) q.remove();
            ans[j]=q.peek().val;
            j+=1;
        }
        return ans;
    }
}