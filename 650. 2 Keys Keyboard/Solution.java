// https://leetcode.com/problems/2-keys-keyboard/?envType=daily-question&envId=2024-08-19



class Solution {
    
    boolean[][] dp;
    
    public int f(int n,int num,int c,int j){
        if(num>n||j>n) return Integer.MAX_VALUE;
        if(num==n) return 0;
        
        if(dp[num][c]) return  Integer.MAX_VALUE;
        dp[num][c]=true;
        
        int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;
        x=f(n,num,num,j+1);
        if(c!=0) y=f(n,num+c,c,j);
        if(x!=Integer.MAX_VALUE) x++;
        if(y!=Integer.MAX_VALUE) y++;
        if(x==Integer.MAX_VALUE&&y==Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return Math.min(x,y);
    }
    public int minSteps(int n) {
        dp=new boolean[1001][1001];
        return f(n,1,0,0);
    }
}
