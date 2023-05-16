class Solution {
    long ans;
    public int divide(int dividend, int divisor) {
        ans=(long)dividend/(long)divisor;
        if(ans > (long)Math.pow(2,31)-1) ans = (long)Math.pow(2,31)-1;
        if(ans < (-1)*(long)Math.pow(2,31)) ans = (long)Math.pow(-2,31);
        return (int)ans;
    }
}