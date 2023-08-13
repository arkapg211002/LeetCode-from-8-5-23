class Solution {
	HashSet<Integer> set;
	public boolean validPartition(int[] nums) {
		set = new HashSet<Integer>();
		return dfs(nums, 0);    
	}

	public boolean dfs(int[] nums, int pos)
    {

		if(pos >= nums.length) return true;
		if(set.contains(pos)) return false; 
		if(pos <= nums.length - 2 && equal(nums[pos], nums[pos + 1]))
			if(dfs(nums, pos + 2)) return true;
		if(pos <= nums.length - 3 && equal(nums[pos], nums[pos + 1], nums[pos + 2]))
			if(dfs(nums, pos + 3)) return true;

		set.add(pos); 
		return false;
	}
	public boolean equal(int a, int b)
    { 
		return a == b;
	}
	public boolean equal(int a, int b, int c)
    {  
		return (a == b && b == c) || (a == b - 1 && b == c - 1);
	}
}