https://leetcode.com/problems/word-break-ii/?envType=daily-question&envId=2024-05-25

```java
class Solution {
  int n;
  Set<String> dict = new HashSet<>();
  List<String> res = new ArrayList<>();
  public void backTrack(String s, int i, String l) {
    if(i == n) 
    {
      res.add(l.substring(0, l.length() - 1));
      return;
    }
    for(int j=i; j<n; j++) 
    {
      var sub = s.substring(i, j+1);
      if(!dict.contains(sub)) continue;
      backTrack(s, j+1, l + sub + " ");
    }
  }
  public List<String> wordBreak(String s, List<String> wordDict) {
    n = s.length();
    for(String word : wordDict) dict.add(word);
    backTrack(s, 0, "");
    return res;
  }
}
```
