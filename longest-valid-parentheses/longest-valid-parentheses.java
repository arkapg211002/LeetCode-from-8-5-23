public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int dp[] = new int[n];
        int res = 0;
        int lc = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') lc+=1;
            else if (lc > 0)
            {
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                res = Math.max(res, dp[i]);
                lc-=1;
            }
        }
        return res;
    }
}