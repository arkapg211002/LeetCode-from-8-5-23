class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int c=0;
        int res=intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            if(intervals[i][0]<res)
            {
                res=Math.min(res,intervals[i][1]);
                c+=1;
            }
            else  res=intervals[i][1];  
        }
        return c;
    }
}