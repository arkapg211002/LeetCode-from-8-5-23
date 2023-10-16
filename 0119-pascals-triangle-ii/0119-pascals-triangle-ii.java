class Solution {
    public List<Integer> getRow(int rowIndex) {
        int c[][]=new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<rowIndex+1;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)c[i][j]=1;
                else c[i][j]=c[i-1][j]+c[i-1][j-1];
            }
        }
        List<Integer>l=new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++)
        {
            l.add(c[rowIndex][i]);
        }
        return l;
    }
}