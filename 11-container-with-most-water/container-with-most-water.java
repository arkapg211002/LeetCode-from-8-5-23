// ----- Without math function -----
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int area = 0;
        while(start<end){
            int s = height[start];
            int l = height[end];
            if(s<=l && area < s*(end-start)){
                area = s*(end-start);
            }else if(s>=l && area < l*(end-start)){
                area = l*(end-start);
            }
            if(s<=l){
                start++;
            }else if(s>=l){
                end--;
            }
        }
        return area;
    }
}