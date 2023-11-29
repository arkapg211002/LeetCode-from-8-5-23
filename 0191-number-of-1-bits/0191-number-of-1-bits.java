public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s=Integer.toString(n);
        int num=Integer.parseInt(s);
        int re;
        if(num<0)re=cn(num);
        else re=cp(num);
        return re;
    }
    public int cp(int n)
    {
        int c=0;
        while(n>0)
        {
            n&=(n-1);
            c+=1;
        }
        return c;
    }
    public int cn(int n)
    {
        int c=0;
        while(n<0)
        {
            n&=(n-1);
            c+=1;
        }
        return c;
    }
}