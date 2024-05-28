https://leetcode.com/problems/get-equal-substrings-within-budget/description/?envType=daily-question&envId=2024-05-28

```java
class Solution {
  public int equalSubstring(String s, String t, int maxCost) {
    int max=0,len=0,cost=0,i=0,j=0;
    while(j < s.length()) 
    {
      if(cost <= maxCost) 
      {
        cost += Math.abs(s.charAt(j) - t.charAt(j));
        j++;
      }
      while(cost > maxCost) 
      {
        cost -= Math.abs(s.charAt(i) - t.charAt(i));
        i++;
      }
      max = Math.max(max, cost);
      len = Math.max(len, j-i);
    }
    return len;
  }
}
```
