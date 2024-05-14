https://leetcode.com/problems/path-with-maximum-gold/description/?envType=daily-question&envId=2024-05-14

```java
class Solution {
    int dir[] = new int[]{0, 1, 0, -1, 0};
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for(int x = 0; x < m; x++)
            for(int y = 0; y < n; y++)
                maxGold = Math.max(maxGold, backtrack(grid, m, n, x, y));
        return maxGold;
    }
    public int backtrack(int grid[][], int m, int n, int x, int y) {
        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0) return 0;
        int maxGold = 0;
        int initialVal = grid[x][y];
        grid[x][y] = 0;
        for(int i = 0; i < 4; i++) 
            maxGold=Math.max(maxGold,backtrack(grid,m,n,dir[i]+x,dir[i+1] + y));
        grid[x][y] = initialVal;
        return maxGold + initialVal;
    }
}
```
