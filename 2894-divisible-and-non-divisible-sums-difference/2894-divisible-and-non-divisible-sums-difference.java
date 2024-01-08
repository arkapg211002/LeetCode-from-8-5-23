class Solution {
    public int differenceOfSums(int n, int m) {
        int totsum=n*(n+1)/2;
        int div=n/m;
        int num2=m*(div*(div+1)/2);
        int num1=totsum-num2;
        return num1-num2;
    }
}