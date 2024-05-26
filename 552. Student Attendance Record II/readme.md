https://leetcode.com/problems/student-attendance-record-ii/description/?envType=daily-question&envId=2024-05-26

```java
class Solution {
    static final int M = 1000000007;
    public int checkRecord(int n) {
        long PorL[] = new long[n + 1]; 
        long P[] = new long[n + 1]; 
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;
        for(int i = 2; i <= n; i++) 
        {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }
        long res = PorL[n];
        for(int i = 0; i < n; i++) 
        { 
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }
        return (int) res;
    }
}
```
