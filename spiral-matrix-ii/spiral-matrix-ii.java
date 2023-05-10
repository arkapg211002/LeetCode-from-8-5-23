class Solution {

    int[][] directions = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int row = 0, col = 0;
        int centerRow = n / 2, centerCol = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int counter = 1;
        m[row][col] = counter++;
        int dirCount = 0;
        int[] direction = directions[dirCount];
        while (!(row == centerRow && col == centerCol)) {
            if (cellExists(row + direction[0], col + direction[1], m)) {
                row += direction[0];
                col += direction[1];
                m[row][col] = counter++;
            } else {
                dirCount++;
                direction = directions[dirCount % 4];
            }
        }
        return m;
    }

    private boolean cellExists(int row, int col, int[][] m) {
        return row >= 0 && row < m.length && col >= 0 && col < m[0].length && m[row][col] == 0;
    }
}