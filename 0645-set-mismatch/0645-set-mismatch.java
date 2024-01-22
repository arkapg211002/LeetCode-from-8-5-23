class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] temp= new int[nums.length];
        int[] ans=new int[2];
        
        for(int num: nums){
            if(temp[num-1]==0) temp[num-1]=-1;
            else  ans[0]=num;
        }
		
        for(int i=0; i< nums.length; i++){
            if(temp[i]==0){
                ans[1]=i+1;
                return ans;
            }
        }
        return ans;
    }
}