// https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/description/?envType=daily-question&envId=2024-08-04

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n * (n + 1) / 2];
        for(int i=0, k=0; i<n; i++){
            int sum = 0; 
            for(int j=i; j<n; j++){
                sum += nums[j];
                arr[k++]=sum;
            }
        }
        Arrays.sort(arr);
        int result = 0;
        int mod = 1000000007;
        for(int i = left - 1; i < right; i++){
            result = (result + arr[i]) % mod;
        }
        
        return result;
    }
}
