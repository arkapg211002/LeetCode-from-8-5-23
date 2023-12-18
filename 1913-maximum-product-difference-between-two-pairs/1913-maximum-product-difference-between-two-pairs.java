class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int p1=nums[nums.length-1]*nums[nums.length-2];
        int p2=nums[0]*nums[1];
        return (p1-p2);
    }
}