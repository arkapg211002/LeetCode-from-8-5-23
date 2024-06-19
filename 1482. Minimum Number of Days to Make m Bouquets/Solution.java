// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/?envType=daily-question&envId=2024-06-19 

class Solution {
     public boolean isPossible(int arr[], int days,int k,int m){
        int n = arr.length;
        int count = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<=days){
                count++;
            }else{
                count = 0;
            }
            if(count==k){
                ans++;
                count = 0;
            }
        }
        return ans>=m;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        // Arrays.sort(bloomDay);
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE, n = bloomDay.length;
        
        
        for(int i=0;i<n;i++){
            start = Math.min(start,bloomDay[i]);
            end = Math.max(end,bloomDay[i]);
        }
        
        int ans = -1;
        int toallFlowers = m*k;
        if(toallFlowers>n)
            return ans;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(isPossible(bloomDay,mid,k,m)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            
        }
        return ans;
        
    }
}
