class Solution {
    public int totalSteps(int[] nums) {
      int ans = 0;
      Stack<Pair<Integer, Integer>> st = new Stack<>();
      st.push(new Pair<>(nums[nums.length-1], 0));
      for(int i=nums.length-2; i>=0; i--){
           int count = 0;
         while(st.size()>0 && nums[i]>st.peek().getKey()){
             count = Math.max(count+1, st.peek().getValue());
              st.pop();
          }
          ans = Math.max(ans, count);
          st.push(new Pair(nums[i], count));
         
      }

      return ans;
    }
}