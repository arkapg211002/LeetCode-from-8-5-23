class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i = 2*n; i >= 0; i--) {
            while(!s.isEmpty() && s.peek() <= nums[i % n]) {
                s.pop();
            }

            if(i < n) {
                if(!s.isEmpty()) {
                    ans[i] = s.peek();
                } else {
                    ans[i] = -1;
                }
            }

            s.push(nums[i % n]);
        }

        return ans;
    }
}