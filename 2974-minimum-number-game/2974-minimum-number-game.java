class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int res[]=new int[nums.length];
        int ind=0;
        for(int num:nums)
            pq.add(num);
        while(pq.size()!=0)
        {
            int a=pq.poll();
            int b=pq.poll();
            res[ind++]=b;
            res[ind++]=a;
        }
        return res;
    }
}