class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        for (int i:batteries) sum+=i;
        long l=1,r=sum/n;
        while (l<r)
        {
            long time=(l+r+1)/2;
            if(check(batteries,n,time)) l=time;
            else r=time-1;
        }
        return l;
    }
    public boolean check(int batteries[],int n,long time)
    {
        long s=0;
        for(int battery:batteries) s+=Math.min(battery,time);
        if(s>=(long)time*n) return true;
        else return false;
    }
}