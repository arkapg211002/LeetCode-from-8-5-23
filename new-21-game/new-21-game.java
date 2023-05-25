class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if(k==0) return 1.00;
        if(k==1 && maxPts<=n) return 1.00;
        double dp[] = new double[n+1];
        dp[0] = 1.00;
        double prev=0.00;
        for(int i=1; i<=n; i++){
            if((i-maxPts-1)>=0){
                prev-=dp[i-1-maxPts];
            }
            if((i-1)<k){
                prev+=dp[i-1];
            }
            dp[i]=prev/maxPts;            
        }

        double res = 0.00;
        for(int i=k; i<=n; i++){
            res+=dp[i];
        }
        return res;        
    }
}

