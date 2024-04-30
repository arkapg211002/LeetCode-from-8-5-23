https://leetcode.com/problems/number-of-wonderful-substrings/description/?envType=daily-question&envId=2024-04-30

```java
public class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Long> prefixCount = new HashMap<>();
        prefixCount.put(0, 1L);
        int mask = 0;
        long result = 0;
        for(char ch : word.toCharArray()) 
        {
            mask ^= (1 << (ch - 'a'));
            result += prefixCount.getOrDefault(mask, 0L);
            for(int i = 0; i < 10; i++) 
            { 
                int maskWithOneFlipped = mask ^ (1 << i);
                result += prefixCount.getOrDefault(maskWithOneFlipped, 0L);
            }
            prefixCount.put(mask, prefixCount.getOrDefault(mask, 0L) + 1);
        }
        return result;
    }
}
```
