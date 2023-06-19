class Solution {
    public int largestAltitude(int[] gain) {
        int g[]=new int[gain.length+1];
        g[0]=0;g[1]=gain[0];
        for(int i=1;i<gain.length;i++)
        {
            g[i+1]=gain[i]+gain[i-1];
            gain[i]=gain[i]+gain[i-1];  
        }
        Arrays.sort(g);
        return g[g.length-1];
    }
}