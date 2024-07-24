// https://leetcode.com/problems/sort-the-jumbled-numbers/description/?envType=daily-question&envId=2024-07-24

class Solution {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    int n = nums.length;
    int arr[][] = new int[n][2];
    for(int i = 0; i < n; i++) 
    {
      arr[i][0] = nums[i];  
      if(nums[i] == 0) arr[i][1] = mapping[0];
      for(int j = nums[i], k = 1; j > 0; j /= 10, k *= 10)
        arr[i][1] += (mapping[j % 10] * k);
    }
    Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
    for (int i = 0; i < n; i++) nums[i] = arr[i][0];
    return nums;
  }
}
