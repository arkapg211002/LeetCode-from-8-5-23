class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 1;
        int start = 0;
        HashMap<Integer, Integer> d = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (!d.containsKey(nums[i])) {
                d.put(nums[i], 1);
            } else {
                d.put(nums[i], d.get(nums[i]) + 1);
                if (d.get(nums[i]) > k) {
                    while (nums[start] != nums[i]) {
                        d.put(nums[start], d.get(nums[start]) - 1);
                        start += 1;
                    }
                    start += 1;
                    d.put(nums[i], d.get(nums[i]) - 1);
                }
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}