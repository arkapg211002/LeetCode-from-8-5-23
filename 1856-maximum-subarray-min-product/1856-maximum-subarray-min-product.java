class Solution {
    public static final long MOD = (int) (1e9 + 7);

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        
        // Calculate the prefix sum of the input array
        long prefixSum[] = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (nums[i] * 1l);
        }
        
        // Stack to keep track of the elements and their indices in a decreasing order
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        long max = 0;
        
        // Traverse through the array to find the maximum product of minimum values
        for (int i = 0; i < n; i++) {
            int index = i;
            
            // Remove elements from the stack while the current element is smaller than the top of the stack
            while (!stack.isEmpty() && stack.peek().getValue() > nums[i]) {
                long minValue = stack.peek().getValue() * 1l;
                int minIndex = stack.peek().getKey();
                
                // Calculate the prefix sum of the current segment between two minimum elements
                long preSum = prefixSum[i] - nums[i] * 1l - ((minIndex - 1) < 0 ? 0 : prefixSum[minIndex - 1]);
                
                // Update the maximum product if a larger product is found
                max = Math.max(max, (preSum * minValue));
                
                // Pop the element from the stack and update the index to be used for next iteration
                stack.pop();
                index = minIndex;
            }
            
            // Push the current element and its index to the stack
            stack.push(new Pair(index, nums[i]));
        }
        
        // Process the remaining elements in the stack
        while (!stack.isEmpty()) {
            long minValue = stack.peek().getValue() * 1l;
            int minIndex = stack.peek().getKey();
            
            // Calculate the prefix sum for the remaining segment
            long preSum = prefixSum[n - 1] - ((minIndex - 1) < 0 ? 0 : prefixSum[minIndex - 1]);
            
            // Update the maximum product if a larger product is found
            max = Math.max(max, (preSum * minValue));
            
            // Pop the element from the stack
            stack.pop();
        }
        
        // Return the maximum product modulo the specified MOD value
        return (int) (max % MOD);
    }
}