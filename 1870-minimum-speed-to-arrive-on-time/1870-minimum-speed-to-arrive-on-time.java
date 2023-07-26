class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour<=dist.length-1) return -1;
        int lo=1;
        int hi=Integer.MAX_VALUE;
        while (lo < hi) 
        {
            int mid = lo + (hi - lo) / 2;
            if (check(dist, hour, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
    public boolean check(int dist[], double hour, int mid) 
    {
        double sum=0;
        for (int i=0;i<dist.length;i++) 
        {
            if (i == dist.length - 1) sum += (double) dist[i] / mid;
            else sum += dist[i] / mid + (dist[i] % mid == 0 ? 0 : 1);
        }
        return (sum<=hour);
    }
}