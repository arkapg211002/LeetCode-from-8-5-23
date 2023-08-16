class Solution {
    public int shortestSubarray(int[] nums, int k) {
         int n = nums.length;
         long sum = 0;
         int min = Integer.MAX_VALUE;
         Deque<Node> dq = new LinkedList<>();
      
         for(int i=0;i<n;i++){
           sum += nums[i];
           if(sum>=k)min = Math.min(min, i+1);
           
           Node curr = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
           
           while(!dq.isEmpty() && sum-dq.peekFirst().val>=k){
             curr = dq.peekFirst();
             dq.pollFirst();
           }
           
            if(curr.val!=Integer.MIN_VALUE){
              min = Math.min(min, i-curr.idx);
            }
              
           while(!dq.isEmpty() && sum<=dq.peekLast().val){
             dq.pollLast();
           }
        
           dq.add(new Node(sum, i));
           
           
         }
           
      return min==Integer.MAX_VALUE?-1:min;
          
         
    }
}
class Node{
      long val;
      int idx;
      Node(long val, int idx){
        this.val = val;
        this.idx = idx;
      }
}