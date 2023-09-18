class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int a[]=new int[mat.length];
        List<Integer>l=new ArrayList<>();
        int c=0;
        for(int i=0;i<mat.length;i++)
        {
            c=0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)c+=1;
            }
            a[i]=c;
            l.add(c);
        }
        Arrays.sort(a);
        int b[]=new int[k];
        for(int i=0;i<k;i++)
        {
            int id=l.indexOf(a[i]);
            b[i]=id;
            l.set(id,a[a.length-1]+1);
        }
        return b;
        
    }
}