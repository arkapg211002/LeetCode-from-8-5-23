class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res=0;
        for(int i=0;i<nums.size();i++)
            if(countSetBits(i)==k) res+=(nums.get(i));
        return res;
    }
    public int countSetBits(int num)
    {
        int c=0;
        while(num>0)
        {
            num &= (num-1);
            c+=1;
        }
        return c;
    }
}