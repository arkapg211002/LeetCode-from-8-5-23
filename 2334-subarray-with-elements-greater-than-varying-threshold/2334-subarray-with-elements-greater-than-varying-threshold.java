class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > threshold) {
                return 1;
            }

            while(stack.peek() != -1 && nums[stack.peek()] > nums[i]) {
                int id = stack.pop();
                
                int len = i - stack.peek() - 1;
                if (nums[id] > threshold / len) {
                    return len;
                }
            }
            
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            int id = stack.pop();
            
            int len = nums.length - stack.peek() - 1;
            if (nums[id] > threshold / len) {
                return len;
            }
        }
        
        return -1;
    }
}