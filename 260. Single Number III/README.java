// https://leetcode.com/problems/single-number-iii/description/?envType=daily-question&envId=2024-05-31

class Solution {
    public int[] singleNumber(int[] nums) {
        int ans =0 ;
        for(int i= 0; i < nums.length;i++)
            ans = ans ^ nums[i];
        ans &= -ans;
        int result[] = new int[2];
        for(int n: nums)
        {
            if((ans & n) == 0)result[0] ^= n;
            else result[1] ^= n;
        }
        return result;
    }
}
