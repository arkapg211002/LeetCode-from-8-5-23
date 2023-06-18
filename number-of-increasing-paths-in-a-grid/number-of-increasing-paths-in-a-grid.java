class Solution {
    int MOD = (int)(1e9+7);
    public int countPaths(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        int res = 0;
        for(int i=0;i<grid.length; i++){
            for(int j=0;j<grid[0].length;j++){
                res = (res+dfs(i, j, grid, memo))%MOD;
            }
        }
        return res;
    }
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    private int dfs(int i, int j, int[][] grid, int[][] memo){
        if(memo[i][j]!=0) return memo[i][j];
        int res = 0;
        for(int[] d: dirs){
            int x = i+d[0], y = j+d[1];
            if(x<0 || y<0 || x==grid.length || y==grid[0].length || grid[x][y]<=grid[i][j]) continue;
            res = (res + dfs(x, y, grid, memo))%MOD;
        }
        return memo[i][j] = res+1;
    }
}