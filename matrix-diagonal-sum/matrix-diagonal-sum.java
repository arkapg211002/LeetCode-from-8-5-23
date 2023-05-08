class Solution {
    public int diagonalSum(int[][] mat) {
        int total = 0;
        int n= mat.length;
        for(int i=0; i<mat.length; i++){
            total = total + mat[i][i]+mat[i][mat.length-1-i];
        }
        if(mat.length%2 == 0){
            return total;
        }
        return total - mat[n/2][n/2];
    }
}