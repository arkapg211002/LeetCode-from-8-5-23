class Solution {
    public int[] countBits(int n) {
        int a[]=new int[n+1];
        for(int i=0;i<n+1;i++)
        {
            a[i]=count(i);
        }
        return a;
    }
    public int count(int n)
    {
        int c=0;
        while(n>0)
        {
            c+=1;
            n&=(n-1);
        }
        return c;
    }
}