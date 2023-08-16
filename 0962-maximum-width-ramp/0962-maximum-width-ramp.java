class Solution {
    public int maxWidthRamp(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        int i = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;

        while (i < n) {
            if (stack.isEmpty() || nums[stack.get(stack.size() - 1)] > nums[i]) {
                stack.add(i);
            } else {
                int l = 0, r = stack.size() - 1;
                int res = Integer.MIN_VALUE;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (nums[stack.get(mid)] <= nums[i]) {
                        res = Math.max(i - stack.get(mid), res);
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }

                max = Math.max(res, max);
            }
            i++;
        }

        return max == Integer.MIN_VALUE?0:max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5});
    }
}