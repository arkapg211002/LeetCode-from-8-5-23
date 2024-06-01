// https://leetcode.com/problems/score-of-a-string/description/?envType=daily-question&envId=2024-06-01

class Solution {
    public int scoreOfString(String s) {
        int total = 0;
        for(int i = 0; i < s.length() - 1; i++) 
            total += Math.abs(s.charAt(i) - s.charAt(i + 1));
        return total;
    }
}
