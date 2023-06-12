class Solution {
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        List<String> res = new ArrayList<String>();
        while(i < nums.length) {
            StringBuilder sb = new StringBuilder(String.valueOf(nums[i]));
            int j = i;
            while (i < nums.length - 1 && nums[i+1] == nums[i] + 1) 
                i++;
            if (i != j) 
                sb.append("->" + nums[i]);
            res.add(sb.toString());
            i++;
        }
        return res;
    }
}