class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long left=index;
        long right=n-index-1;
        long start=1;
        long end=maxSum;
        while(start<=end) {
            long mid=start+(end-start)/2;
            long m=mid-1;
            long ls=0;
            long rs=0;
            if(m>=left) {
                long notInRange=m-left;
                ls=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else {
                ls=m*(m+1)/2+1*(left-m);
            }
            if(m>=right) {
                long notInRange=m-right;
                rs=m*(m+1)/2-(notInRange)*(notInRange+1)/2;
            }
            else {
                rs=m*(m+1)/2+1*(right-m);
            }
            long sum=rs+ls+mid;
            if(sum>maxSum) {
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        return (int)end;
    }
}