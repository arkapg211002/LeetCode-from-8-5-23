class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>l=new ArrayList<>();
        for(int i=0;i<graph.length;i++)l.add(new ArrayList<>());
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
                l.get(i).add(graph[i][j]);
        }
        
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            int vis[]=new int[graph.length];
            int pathVis[]=new int[graph.length];
            if(dfs(i,l,vis,pathVis)==false)ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int node,ArrayList<ArrayList<Integer>>l,int vis[],int pathVis[]) 
    {
        vis[node]=1;
        pathVis[node]=1;
        for(int it : l.get(node)) 
        {
            if(vis[it] == 0) {
                if(dfs(it,l,vis,pathVis)==true) 
                    return true; 
            }
            else if(pathVis[it] == 1)return true;
        }
        pathVis[node] = 0; 
        return false; 
    }
    
}