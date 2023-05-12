class Solution {
    public long mostPoints(int[][] questions) {
        long dp[]=new long[questions.length];
        return f(0,questions,dp);
    }
    public long f(int ind,int q[][],long dp[]){
        if(ind>=q.length) return 0;
        if(dp[ind]!=0) return dp[ind];
        long t=q[ind][0] + f(ind + q[ind][1]+1,q,dp);
        long nt=f(ind + 1,q,dp);
        return dp[ind]=Math.max(t,nt);
    }
}