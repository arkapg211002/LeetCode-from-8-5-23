class Solution {
    private Integer[][] memoi;
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int sum[]=new int[n+1];
        for (int i = 0; i < n; i++) 
            sum[i+1] = sum[i] + piles[i];
        memoi = new Integer[n][2*n];
        int diff = dp(sum, 0, 1);
        return (sum[n] + diff) / 2;
    }
    public int dp(int[] sum, int left, int M) 
    {
        if (left >= sum.length-1) return 0; 
        if (memoi[left][M] != null) return memoi[left][M];
        int ans = Integer.MIN_VALUE;
        for (int l = 1; l <= 2 * M; l++) 
        {
            int j = Math.min(l + left - 1, sum.length - 2);
            ans = Math.max(ans, sum[j+1] - sum[left] - dp(sum, j+1, Math.max(M, l)));
        }
        return memoi[left][M] = ans;
    }
}