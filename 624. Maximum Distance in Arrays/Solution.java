// https://leetcode.com/problems/maximum-distance-in-arrays/description/?envType=daily-question&envId=2024-08-16

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secondMin = 100001;
        int secondMax = -100001;
        int minIndex = -1;
        int maxIndex = -1;



        for(int i=0;i<arrays.size();i++){
            List<Integer> l = arrays.get(i);
            if(l.get(0)<=min){
                secondMin = min;
                min = l.get(0);
                minIndex = i;
                
            } else if(l.get(0)<=secondMin){
                secondMin = l.get(0);
            }
            if(l.get(l.size()-1)>=max){
                secondMax = max;
                max = l.get(l.size()-1);
                maxIndex = i;
                
            } else if(l.get(l.size()-1)>=secondMax){
                secondMax = l.get(l.size()-1);
            }
            
        }
        if(minIndex!=maxIndex){
            return Math.abs(max-min);
        } else {
            return Math.max(Math.abs(max-secondMin), Math.abs(min-secondMax));
        }
        
        
    }
}
