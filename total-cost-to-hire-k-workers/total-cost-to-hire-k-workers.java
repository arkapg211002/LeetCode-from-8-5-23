class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]==b[0] ? a[1]-b[1]:a[0]-b[0]);
        long res=0;int l=0,r=costs.length-1;
        for(int i=0;i<candidates;i++){
            q.offer(new int[]{costs[l],l++});
            q.offer(new int[]{costs[r],r--});
        }
        for(int i=0;i<k;i++){
            int[] ab=q.poll();
            res+=ab[0];
            if(ab[1]<=l && l<=r)
                q.offer(new int[]{costs[l],l++});
            else if(ab[1]>=r && r>=l)
                q.offer(new int[]{costs[r],r--});
            if(!q.isEmpty() && q.peek()[1]==ab[1]) q.poll();
        }
        return res;
    }
}