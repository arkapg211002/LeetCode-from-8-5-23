class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = nums[0];
      for(int i=0; i<nums.length; i++ ) {
         if(nums[i]<min) {
            min = nums[i];
         }
      }
        int max = 0;
      for(int i=0; i<nums.length; i++ ) {
         if(nums[i]>max) { 
             max = nums[i];
            }
      }
          if( nums.length<3) {
             return -1;
             }
              else {
               for(int num:nums){
                  if(num!=min && num!=max){
                      return num;
                  }
                }
              }
                   return -1;
    }
 }