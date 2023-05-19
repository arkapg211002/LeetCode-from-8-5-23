class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>>l=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            l.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                l.get(i).add(graph[i][j]);
                l.get(graph[i][j]).add(i);
            }
        }
        int col[]=new int[graph.length];
        Arrays.fill(col,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(col[i]==-1)
            {
                if(dfs(i,0,l,col)==false)return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int c,ArrayList<ArrayList<Integer>>l,int col[])
    {
        col[node]=c;
        for(Integer it:l.get(node))
        {
            if(col[it]==-1)
            {
                if(dfs(it,1-c,l,col)==false)return false;
            }
            else if(col[it]==c)return false;
        }
        return true;
    }
}