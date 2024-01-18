/*Recursion

class Solution {
    public int climbStairs(int n) {
        if(n==0)return 1;
        if(n==1)return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}*/

/* Memoization
class Solution
{
    public int climbStairs(int n)
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        return f(n,dp);
    }
    public int f(int ind,int dp[])
    {
        if(ind==0 || ind==1)return 1;
        if(dp[ind]!=-1)return dp[ind];
        return dp[ind]=f(ind-1,dp)+f(ind-2,dp);
    }
}
*/

/* Tabulation
class Solution
{
    public int climbStairs(int n)
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        for(int ind=2;ind<=n;ind++)
        {
            dp[ind]=dp[ind-1]+dp[ind-2];
        }
        return dp[n];
    }
}
*/

class Solution
{
    public int climbStairs(int n)
    {
        int prev2=1,prev=1,cur;
        for(int ind=2;ind<=n;ind++)
        {
            cur=prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}