import java.util.*; 

class Node 
{
	private int u;
    private int v;
    private int weight;
    
    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}

class SortComparator implements Comparator<Node> {
	@Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.getWeight() < node2.getWeight()) 
            return -1; 
        if (node1.getWeight() > node2.getWeight()) 
            return 1; 
        return 0; 
   

    } 
} 

class Solution {
    public int findPar(int u, int parent[]) {
		if(u==parent[u]) return u;
		return parent[u] = findPar(parent[u], parent); 
	}
	public void union(int u, int v, int parent[], int rank[]) {
		u = findPar(u, parent); 
		v = findPar(v, parent);
		if(rank[u] < rank[v]) {
        	parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
        	parent[v] = u; 
        }
        else {
        	parent[v] = u;
        	rank[u]++; 
        }
	}
    public int KruskalAlgo(ArrayList<Node> adj, int N)
    {
        Collections.sort(adj, new SortComparator());
        int parent[] = new int[N]; 
        int rank[] = new int[N];
        for(int i = 0;i<N;i++) {
        	parent[i] = i; 
        	rank[i] = 0; 
        }
        int costMst = 0;
        for(Node it: adj) {
        	if(findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
        		costMst += it.getWeight(); 
        		union(it.getU(), it.getV(), parent, rank); 
        	}
        } 
        return costMst;
    }
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Node>l=new ArrayList<>();
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int d=(int)Math.abs(points[i][0]-points[j][0])+(int)Math.abs(points[i][1]-points[j][1]);
                l.add(new Node(i,j,d));

            }
        }
        return KruskalAlgo(l,points.length);
    }
}