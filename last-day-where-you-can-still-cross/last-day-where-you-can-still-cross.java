class Solution {
    public static final int[][] ds = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int row, col;
    boolean[][] vi, land;
    private boolean dfs (int i, int j) {
        if(i == row - 1) return true;
        if(!vi[i][j] || (vi[i][j] && !land[i][j])) {
            if(vi[i][j]) land[i][j] = true;
            vi[i][j] = true;
            for (int[] d : ds) {
                int x = d[0] + i, y = d[1] + j;
                if(x >= 0 && x < row && y >= 0 && y < col) {
                    if(!vi[x][y] && land[x][y]) {
                        if(dfs(x, y)) return true;
                    }
                    else if(!land[x][y]) vi[x][y] = true; 
                }
            }
        }
        return false;
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row; this.col = col;
        land = new boolean [row][col];
        vi = new boolean [row][col];
        //false == water
        for (int i = cells.length - 1; i >= 0; i--) {
            //lastday -> 0th day
            int r = --cells[i][0], c = --cells[i][1];
            if(vi[r][c] && land[r][c]) continue; //visited
            if(r == 0) {
                land[r][c] = true;
                vi[r][c] = false;
                if(dfs(r, c)) return i;
            }
            else if(vi[r][c]) {
                if(dfs(r, c)) return i;
            }
            land[r][c] = true; //island recovery
        }
        return 0;
    }
}