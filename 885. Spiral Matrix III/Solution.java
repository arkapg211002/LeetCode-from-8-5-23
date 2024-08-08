// https://leetcode.com/problems/spiral-matrix-iii/description/?envType=daily-question&envId=2024-08-08

class Solution {
    int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] spiralMatrixIII(int rows, int cols,
            int rStart, int cStart) {

        int[][] res = new int[rows * cols][2];
        int idx = 0;
        res[idx++] = new int[] { rStart, cStart };

        int idx_d = 0, len = 0;
        while (idx < rows * cols) {
            if (idx_d == 0 || idx_d == 2) {
                len++;
            }

            for (int i = 0; i < len; i++) {
                rStart += dir[idx_d][0];
                cStart += dir[idx_d][1];
                if (rStart >= 0 && rStart < rows
                        && cStart >= 0 && cStart < cols) {
                    res[idx++] = new int[] { rStart, cStart };
                }
            }
            idx_d = (idx_d + 1) % 4;
        }
        return res;
    }
}
