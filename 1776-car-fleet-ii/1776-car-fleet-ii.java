class Solution {
    class Node {
        int id; // car_id
        double time; // the time for collision with the next car
        
        public Node(int _id, double _time) {
            id = _id;
            time = _time;
        }
    }
    public double[] getCollisionTimes(int[][] cars) {
        PriorityQueue<Node> pq = new PriorityQueue<>(200000, (a, b) -> Double.compare(a.time, b.time));
        
        int n = cars.length;
        for (int i = 0; i < n - 1; ++i) {
            if (cars[i][1] > cars[i+1][1]) { // if there could be collision for i-th car and i+1-th car
                pq.offer(new Node(i, (double)(cars[i+1][0] - cars[i][0]) / (double)(cars[i][1] - cars[i+1][1])));
            }
        }
        
        double[] res = new double[n];
        Arrays.fill(res, -1.0);
        TreeSet<Integer> ts = new TreeSet<>(); // used to record all alive cars
        for (int i = 0; i < n; ++i) {
            ts.add(i);
        }
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (res[cur.id] != -1.0) // this means such car is already processed in previous steps
                continue;
            res[cur.id] = cur.time;
            if (ts.lower(cur.id) == null) // if there is no previous car, no need for update
                continue;
            int prev = ts.lower(cur.id); // find the previous alive car
            int next = ts.higher(cur.id); // find the next car, since this is the next car of the previous car now
            if (cars[prev][1] > cars[next][1]) { // update the information of previous car
                pq.offer(new Node(prev, (double)(cars[next][0] - cars[prev][0]) / (double)(cars[prev][1] - cars[next][1]))); 
            }
            ts.remove(cur.id); // such car is dead, remove it
        }
        
        return res;
    }
}