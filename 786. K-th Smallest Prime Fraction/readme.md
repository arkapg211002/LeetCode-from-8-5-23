https://leetcode.com/problems/k-th-smallest-prime-fraction/description/?envType=daily-question&envId=2024-05-10

```java
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i< arr.length - 1; i++)
        {
            for(int j=i+1; j< arr.length; j++)
            {
                double frac = (double)arr[i]/arr[j];
                maxHeap.add(new Pair(frac, arr[i], arr[j]));
                if(maxHeap.size()>k) maxHeap.remove(maxHeap.peek());
            }
        }
        return new int[]{maxHeap.peek().val1,maxHeap.peek().val2};
    }
    public class Pair implements Comparable<Pair>
    {
        double frac ; 
        int val1 ;
        int val2 ;
        Pair(double frac , int val1 , int val2)
        {
            this.frac = frac;
            this.val1 = val1; 
            this.val2 = val2;
        }
        public int compareTo(Pair o)
        {
            if(this.frac > o.frac){
                return 1;
            }
            return -1;
        }
    }
}
```
