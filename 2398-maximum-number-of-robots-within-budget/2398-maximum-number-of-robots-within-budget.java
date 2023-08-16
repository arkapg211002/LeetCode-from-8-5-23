class Solution {
    public int maximumRobots(int[] ct, int[] rc, long budget) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = rc.length;
        int res = Integer.MIN_VALUE;
        long cost = 0;
        for (int i = 0, j = 0; i < n; i++) {
            cost += rc[i];
            pq.add(ct[i]);
            while (!pq.isEmpty() && (pq.peek() + pq.size() * cost > budget)) {
                pq.remove(ct[j]);
                cost -= rc[j];
                j++;
            }
            res = Math.max(res, pq.size());
        }
        return res;
    } 
}