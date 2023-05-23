class KthLargest {
    
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int n : nums) add(n);
    }
    
    public int add(int val) {
        if(pq.size() < k) pq.offer(val);
        else if(val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}