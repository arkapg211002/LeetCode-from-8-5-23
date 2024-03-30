class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    public int helper(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, left = 0;
        for(int right = 0; right < nums.length; right++) 
        {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k) 
            {
                if(map.get(nums[left]) == 1)  map.remove(nums[left]);
                else map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                left++;
            } 
            count += (right - left + 1);
        }
        return count;
    }
}