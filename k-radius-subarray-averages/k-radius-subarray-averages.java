class Solution {
    public int[] getAverages(int[] nums, int k) {
        int arr[]= new int[nums.length];
        double sum=0;
        Arrays.fill(arr,-1);
        if(2*k>=nums.length)
            return arr;
        for(int i=0;i<2*k+1;i++)
            sum+=nums[i];
        double avg=sum/(2*k+1);
        arr[k]=(int)avg;
        for(int i=k+1;i<nums.length-k;i++)
        {
            sum-=nums[i-k-1];
            sum+=nums[i+k];
            double a=sum/(2*k+1)*1.0;
            arr[i]=(int)a;
        }
        return arr;
    }
}