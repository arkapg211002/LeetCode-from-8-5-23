class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int arr[] = new int[nums.length];
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            arr[i] += sum;
            int index = bSearch(arr,sum-target,i);
            if(index>0&&arr[i]-arr[index-1]>=target) {
                //.out.println(i+"->"+index);
                ans = Math.min(ans,i-index);
            }
            else if(index==0&&arr[i]>=target) {
                //System.out.println(i+"->"+index);
                ans = Math.min(ans,i-index+1);
            }
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
    int bSearch(int arr[],int tgt,int high) {
        int low = 0;
        int index = 0;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(arr[mid]>tgt) {
                high = mid-1;
            }
            else {
                index = mid;
                low = mid+1;
            }
        }
        return index;
    }
}