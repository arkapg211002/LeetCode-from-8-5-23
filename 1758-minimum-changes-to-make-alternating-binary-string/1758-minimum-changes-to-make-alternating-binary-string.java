class Solution {
    public int minOperations(String s) {
        char flipBit = '0';
        int ans1 = 0, ans = 0;
        
        for(char c : s.toCharArray()) {
            if(c != flipBit) ans++;
            else ans1++;
            flipBit^=1;
        }
        
        return Math.min(ans, ans1);
    }
}