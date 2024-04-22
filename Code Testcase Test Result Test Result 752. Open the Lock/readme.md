https://leetcode.com/problems/open-the-lock/description/?envType=daily-question&envId=2024-04-22

```java
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> prohibited = new HashSet<>();
        HashSet<String> vis = new HashSet<>();
        for(String it : deadends) prohibited.add(it);
        int ans = 0;
        Queue<StringBuilder> q = new LinkedList<>();
        q.offer(new StringBuilder("0000"));
        vis.add("0000");
        while(!q.isEmpty())
        {
            int n = q.size();
            while(n-- > 0)
            {
                StringBuilder res = q.poll();
                if(target.equals(res.toString())) return ans;
                if(prohibited.contains(res.toString())) continue;
                for(int i = 0;i < 4;i++)
                {
                    StringBuilder temp = new StringBuilder();
                    for(int j = 0;j < 4;j++)
                    {
                        if(i == j)
                        {
                            int val = res.charAt(j)-'0';
                            val++;
                            val %= 10;
                            temp.append(val);
                        }
                        else temp.append(res.charAt(j));
                    }
                    if(!vis.contains(temp.toString()))
                    {
                        vis.add(temp.toString());
                        q.offer(temp);
                    }
                    temp = new StringBuilder();
                    for(int j = 0;j < 4;j++)
                    {
                        if(i == j)
                        {
                            int val = res.charAt(j)-'0';
                            val--;
                            if(val < 0) val = 9;
                            temp.append(val);
                        }
                        else temp.append(res.charAt(j));
                    }
                    if(!vis.contains(temp.toString()))
                    {
                        vis.add(temp.toString());
                        q.offer(temp);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
```
