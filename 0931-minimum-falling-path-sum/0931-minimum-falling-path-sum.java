class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i=0; i<m; i++)
            dp[0][i] = matrix[0][i];
        for(int i=1; i<n; i++)
        {
            for(int j=0;j<m;j++)
            {
                int up = matrix[i][j] + dp[i-1][j];
                int ld= matrix[i][j];
                if(j-1>=0) ld += dp[i-1][j-1];
                else ld += (int)1e9;
                int rd = matrix[i][j];
                if(j+1<m) rd += dp[i-1][j+1];
                else rd += (int)1e9;
                dp[i][j] = Math.min(up, Math.min(ld,rd));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<m;j++)
            ans = Math.min(ans,dp[n-1][j]);    
        return ans;
    }
}