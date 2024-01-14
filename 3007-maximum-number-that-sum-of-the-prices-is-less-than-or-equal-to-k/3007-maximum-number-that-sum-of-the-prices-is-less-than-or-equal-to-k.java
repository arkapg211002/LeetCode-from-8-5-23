class Solution {
    public long findMaximumNumber(long k, int x) {
        long left=1L,right=(long)1e15,ans=0L;
        while(left<=right)
        {
            long mid=left+(right-left)/2;
            if(valid(mid,x,k))
            {
                ans=(long)Math.max(ans,mid);
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return ans;
    }
    public boolean valid(long mid,int x,long k)
    {
        long sum=0L;
        for(int i=x;i<64;i+=x)
        {
            //if(i%x!=0) continue;
            long pow=(long)Math.pow(2,i);
            long rem=mid%pow;
            long pow2=pow/2;
            sum+=(mid/pow)*pow2;
            if(rem>=pow2) sum+=rem+1-pow2;
            if(sum>k) return false;
        }
        return true;
    }
}