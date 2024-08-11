// https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/?envType=daily-question&envId=2024-08-11

class Solution {
    int[] xDir = {0,0,-1,1};
    int[] yDir = {-1,1,0,0};
    public boolean isSafe(int[][] grid,int i,int j,boolean[][] visited)
    {
        return(i>=0 && j>=0 && i<grid.length  && j<grid[0].length && visited[i][j] == false && grid[i][j] == 1);
    }
    public void islandCount(int[][] grid,int i,int j,boolean[][] visited)
    {
        visited[i][j] = true;
        for(int k = 0;k<4;k++)
        {
            int newRow = i+xDir[k];
            int newCol = j+yDir[k];
            if(isSafe(grid,newRow,newCol,visited))
            {
                islandCount(grid,newRow,newCol,visited);
            }
        }
    }
    public int CountLand(int[][] grid,boolean[][] visited)
    {
        int count = 0;
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1 && visited[i][j] == false)
                {
                    islandCount(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
    public int minDays(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = CountLand(grid,visited);
        if(count > 1 || count == 0) return 0;
        for(int i = 0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if(grid[i][j] == 1)
                {
                    grid[i][j] = 0;
                    boolean[][] mat = new boolean[rows][cols];
                    int count2 = CountLand(grid,mat);
                    grid[i][j] = 1;
                    if(count2 > 1 || count2 == 0)
                    {
                        return 1;   
                    }
                }
            }
        }
        return 2;
    }
}
