class Solution {
    public int minOperations(int[] nums, int x) {
        // Min Operations to find x  = Length of nums - Max operations to find the longest substring of unwanted 
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        int maxUnwanted = -1;
        int unwantedTarget = sum - x;
        int left = 0;
        int curr = 0;
        int count = 0;
        
        if(x > sum) return -1;
        
        for(int right = 0; right < nums.length; right++){
            curr += nums[right];
            count++;

            while(curr > unwantedTarget){
                curr -= nums[left++];
                count--;
            }
                
            if(curr == unwantedTarget){
                maxUnwanted = Math.max(maxUnwanted, count);
            }
        }
        
        return maxUnwanted == -1 ? -1 : nums.length - maxUnwanted;
    }
}