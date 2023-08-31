class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Modify the numbers and target to simplify the problem
        for (int i = 0; i < numbers.length; i++)
            numbers[i] += 1001;
        target += 2002;
        
        // Initialize pointers to the start and end of the modified numbers array
        int start = 0;
        int end = numbers.length - 1;
        int temp = target;
        
        // Search for two numbers that sum up to the modified target
        while (numbers[start] + numbers[end] != target) {
            // Move the 'end' pointer leftward if the current sum is larger than the target
            while (temp < numbers[end])
                end--;
            temp = target - numbers[end];
            
            // Move the 'start' pointer rightward if the current sum is smaller than the target
            while (temp > numbers[start])
                start++;
            
            // If a pair of numbers is found that sum up to the target, return their indices
            if (numbers[start] + numbers[end] == target)
                return new int[]{start + 1, end + 1};
            
            temp = target - numbers[start];
            // again come back
        }
        
        // Return the indices of the found pair
        return new int[]{start + 1, end + 1};
    }
}