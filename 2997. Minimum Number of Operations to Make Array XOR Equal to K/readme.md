https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/?envType=daily-question&envId=2024-04-29

```java
class Solution {
    public int minOperations(int[] nums, int k) {
        int xor=0;
        for(int num:nums) xor ^= num;
        int diff=(xor ^ k);
        return Integer.bitCount(diff);      
    }
}
```
