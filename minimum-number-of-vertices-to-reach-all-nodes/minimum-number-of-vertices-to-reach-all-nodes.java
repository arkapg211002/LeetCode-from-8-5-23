class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int v[]=new int[n];
        for(int i=0;i<edges.size();i++)
        {
            if(v[edges.get(i).get(1)]==0)v[edges.get(i).get(1)]=1;
            else continue;
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
            if(v[i]==0)ans.add(i);
        return ans;
    }
}