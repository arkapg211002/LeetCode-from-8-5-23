class Solution {
    public int minPairSum(int[] nums) {
        List<Integer>l=new ArrayList<>();
        for(int i=0;i<nums.length;i++)l.add(nums[i]);
        Collections.sort(l);
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n/2;i++)
            max=(int)Math.max(max,(l.get(i)+l.get(n-1-i)));
        return max;
    }
}