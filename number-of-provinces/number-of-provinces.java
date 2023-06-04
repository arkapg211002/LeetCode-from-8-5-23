class Solution {
    public int findCircleNum(int[][] isConnected) {
        int vis[]=new int[isConnected.length];
        ArrayList<ArrayList<Integer>>l=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)l.add(new ArrayList<>());
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1)
                {
                    l.get(i).add(j);
                    l.get(j).add(i);
                }
            }
        }
        int c=0;
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                c+=1;
                dfs(i,l,vis);
            }
        }
        return c;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>>l,int vis[])
    {
        vis[node]=1;
        for(Integer it:l.get(node))
        {
            if(vis[it]==0)
                dfs(it,l,vis);
        }
    }
}