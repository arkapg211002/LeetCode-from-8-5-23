class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length,i=0,j=n-1,l=0,r=n-1;
        while(i<m){
            if(matrix[i][j]<target) i++;
            else{
                while(l<=r){
                    int mid=l+(r-l)/2;
                    if(matrix[i][mid]==target) return true;
                    else if(matrix[i][mid]<target) l=mid+1;
                    else r=mid-1;
                }
                return false;
            }
        }
        return false;
    }
}