// https://leetcode.com/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-06-17

class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<0) return false;
        long left=0;
        long right = (int)Math.sqrt(c);
        while(left<=right)
        {
            long sum = left*left+right*right;
            if(sum==c) return true;
            else if(sum<c) left++;
            else right--;
        }
        return false;  
    }
}
