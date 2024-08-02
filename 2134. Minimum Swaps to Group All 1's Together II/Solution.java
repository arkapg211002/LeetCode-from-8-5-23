// https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/?envType=daily-question&envId=2024-08-02

class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int num : nums) if (num == 1) totalOnes++;  
        if (totalOnes <= 1) return 0;
        int[] extended = new int[nums.length * 2];
        System.arraycopy(nums, 0, extended, 0, nums.length);
        System.arraycopy(nums, 0, extended, nums.length, nums.length);
        int maxOnes = 0;
        int currentOnes = 0;
        for (int i = 0; i < totalOnes; i++) 
            if (extended[i] == 1) currentOnes++;
        maxOnes = currentOnes;
        for (int i = 1; i < nums.length; i++) 
        {
            if (extended[i - 1] == 1) currentOnes--;
            if (extended[i + totalOnes - 1] == 1) currentOnes++;
            maxOnes = Math.max(maxOnes, currentOnes);
        }
        int minSwaps = totalOnes - maxOnes;   
        return minSwaps;
    }
}
