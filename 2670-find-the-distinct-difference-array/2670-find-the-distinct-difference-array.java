class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> prefix = new HashMap<>();
        HashMap<Integer,Integer> suffix = new HashMap<>();
        int[] ans = new int[nums.length];
        int[] prearr = new int[nums.length];
        int[] suffarr = new int[nums.length];

        int k =0;
        int x = 0;
        for(int i=0; i<nums.length; i++){
            for(int j =0; j<=i; j++){
                if(!prefix.containsKey(nums[j])){
                    prefix.put(nums[j],1);
                }
            }
            int pref_val = prefix.size();
            k++;
            
            int count = 0;
            for(int j = i+1; j<n; j++){
                
                if(!suffix.containsKey(nums[j])){
                    suffix.put(nums[j],1);
                }
                
            }
            int suff_val = suffix.size();
            suffix.clear();

            ans[i] = pref_val - suff_val;
            
            System.out.println(suff_val);
        }
        
        
       
        
        return ans;
    }
}