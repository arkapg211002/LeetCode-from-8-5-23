class Solution {
    
    long dp[][] = new long[1001][1001];
    int MOD = 1000000007;
    
    public int numOfWays(int[] nums) {
        dp[0][0]=1;
        for(int i = 1; i <= nums.length; i++){
            dp[i][0]=1;
            dp[i][i]=1;
            for(int j = 1; j < i; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int val : nums) 
            list.add(val);
        
        return (int) solve(list)-1;
    }
    
    public long solve(List<Integer> l) {
        int size = l.size();
        if(size <= 1) return 1;
        
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        
        for(int i = 1 ; i < l.size() ; i++) {
            int val = l.get(i);
            if(val < l.get(0))
                small.add(val);
            else
                large.add(val);
        }
        long ansS = solve(small);
        long ansL = solve(large);
        long ans = (ansS * ansL) % MOD;
        ans = (long) (ans * dp[size-1][small.size()] % MOD);
       
        return ans;
    }
}