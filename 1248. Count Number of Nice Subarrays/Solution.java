// https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=daily-question&envId=2024-06-22

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++) nums[i] = nums[i]%2;
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
