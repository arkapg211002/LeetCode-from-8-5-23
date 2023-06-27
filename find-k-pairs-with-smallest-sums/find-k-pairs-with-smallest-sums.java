class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pair>pq = new PriorityQueue<>();
        for(int i=0; i<nums1.length; i++){
            pq.add(new pair(nums1[i],nums2[0],nums1[i]+nums2[0],0));
        }
        List<List<Integer>>ans = new ArrayList<>();
        while(k>0 && pq.size()>0){
            pair a = pq.remove();
            List<Integer>aa = new ArrayList<>();
            aa.add(a.d1);
            aa.add(a.d2);
            ans.add(aa);
            int index = a.idx;
            if(index < nums2.length-1){
                pq.add(new pair(a.d1,nums2[index+1],a.d1+nums2[index+1],index+1));
            }
            k--;
        }
        return ans;
    }
}
public class pair implements Comparable<pair>
{
    int d1;
    int d2;
    int sum;
    int idx;
    pair(int d1,int d2,int s,int idx){
        this.d1 = d1;
        this.d2 = d2;
        this.sum = s;
        this.idx = idx;
    }
    public int compareTo(pair other){
        return this.sum-other.sum;
    }
}
