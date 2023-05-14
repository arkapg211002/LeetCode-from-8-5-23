class Solution {
    Map<String, Integer> dp;
    public int maxScore(int[] nums) {
        dp=new HashMap<>();
        return util(nums, new boolean[nums.length], nums.length/2);
    }
    public int gcd(int x, int y) 
    {
        if(x==0) return y;
        else if(y==0) return x;
        else return gcd(y, x%y);
    }
    public int util(int arr[], boolean taken[], int operations) 
    {
        if(operations==0) return 0;
        String key=Arrays.toString(taken)+"|"+operations;
        if(dp.containsKey(key)) return dp.get(key);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) 
        {
            for(int j=i+1;j<arr.length;j++) 
            {
                if(!taken[i] && !taken[j]) 
                {
                    taken[i]=taken[j]=true;
                    int val=(operations*gcd(arr[i], arr[j]))+util(arr, taken, operations-1);
                    max=Math.max(max, val);
                    taken[i]=taken[j]=false;
                }
            }
        }
        dp.put(key, max);
        return max;
    }
}