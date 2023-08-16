class Solution {
    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length, INF = (int)1e9;
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0]=0;
        Deque<int[]> deque = new ArrayDeque<>();
        long[] pre = new long[n+1];
        int[] diff= new int[n+1];
        for (int i = 1; i <= n; i++){ // prefix sum for weight 
            pre[i]=boxes[i-1][1]+pre[i-1];
        }
        for (int i = 2; i <= n; i++){ // additional cost
            diff[i]=boxes[i-1][0]==boxes[i-2][0]?diff[i-1]:diff[i-1]+1;
        }
        deque.offer(new int[]{0, 0}); // base case 
        for (int i = 1 ; i<=n; i++){
            while(i - deque.peekFirst()[0] > maxBoxes || pre[i] - pre[deque.peekFirst()[0]] > maxWeight){ // invalid, remove it
                deque.pollFirst();
            }
            dp[i]=diff[i]-diff[deque.peekFirst()[0]+1]+dp[deque.peekFirst()[0]]+2; // dp value
            int cur = dp[i] - diff[i==n?0:i+1];
            while(!deque.isEmpty() && cur < deque.peekLast()[1]){ // purge based on adjusted value, NOT dp value
                deque.pollLast();
            }
            deque.offerLast(new int[]{i, cur}); // put adjusted value into the mono queue.
        }
        return dp[n];
    }
}