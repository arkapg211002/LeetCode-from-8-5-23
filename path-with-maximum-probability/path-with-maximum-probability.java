import java.util.*; 

class Node implements Comparator<Node>
{
    private int v;
    private double weight;
    
    Node(int _v, double _w) { v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    double getWeight() { return weight; }
    
    @Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.weight > node2.weight) 
            return -1; 
        if (node1.weight < node2.weight) 
            return 1; 
        return 0; 
    } 
}
class Solution {
    public double shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N, int end)
    {
        double dist[] = new double[N];
        
        for(int i = 0;i<N;i++) dist[i] = 0.00000;
        dist[s] = 1.00000; 
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
        pq.add(new Node(s, 1.00000));
        
        while(pq.size() > 0) {
            Node node = pq.poll();
            
            for(Node it: adj.get(node.getV())) {
                if(dist[node.getV()] * it.getWeight() > dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] * it.getWeight(); 
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }
        
        if(dist[end]==0.00000)return 0.00000;
        else return dist[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<ArrayList<Node>>l=new ArrayList<>();
        for(int i=0;i<n;i++)l.add(new ArrayList<Node>());
        int i=0;
        for(int r[]:edges)
        {
            l.get(r[0]).add(new Node(r[1],succProb[i]));
            l.get(r[1]).add(new Node(r[0],succProb[i]));
            i+=1;
        }
        return shortestPath(start, l, n, end); 
    }
    
}