class Solution {
    public int minKBitFlips(int[] A, int K) {
        // use an count to check how many times current element has been fliped
        int out = 0, count=0;
        // use an boolean array to track till what array element you will flip
        boolean[] checkFlip = new boolean[A.length];
        for(int i=0; i<A.length; i++){
            // You need to flip only if A[i] == 0 and you haven’t fliped it or all the flips have been Canceled due even number of flips
            // You will also need to flip if you have fliped A[i]==1 odd number of times.
            if( (A[i]==0 && count%2==0) || (A[i]==1 && count%2!=0)){
                count++;
                out++;
                if(i+K-1>=A.length){
                    // You will return -1 as you encountered an element which needs flip but there aren't enough elements to flip ahead and all the previous elements are 1.
                    return -1;
                }else{
                    // If you flip a current elements use checkFlip to keep track till which element current flip has effect.
                    checkFlip[i+K-1] = true;
                }
            }
            if(checkFlip[i]){
                // Decrement the count as you are passing a element till which certain flip was active
                count--;
            }
        }
        return out;
    }
}