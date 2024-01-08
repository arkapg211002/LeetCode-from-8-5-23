class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l=0,r=nums.size()-1,c=0;
        while(l<=r)
        {
            if(nums.get(l)+nums.get(r)<target)
            {
                c+=(r-l);
                l+=1;
            }
            else r-=1;
        }
        return c;
    }
}