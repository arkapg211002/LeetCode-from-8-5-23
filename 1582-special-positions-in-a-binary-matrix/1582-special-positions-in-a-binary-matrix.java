class Solution {
    public int isSpecial(int[][] mat, int col){
        // check vertically
        int seenBefore = 0;
        for(int i=0; i<mat.length; i++){
             if(seenBefore==1  && mat[i][col] ==1){
                    seenBefore = 0;
                    break;
                }else if(mat[i][col] ==1) {
                    seenBefore= 1;
                }
        }
        return seenBefore;
    }
    public int numSpecial(int[][] mat) {
         int counter = 0;
        
        for(int i=0; i<mat.length; i++){
            int lastFoundAt = -1;
            
            // check horizontally
            for(int j=0; j<mat[i].length; j++){
                
                if(lastFoundAt>=0 && mat[i][j] ==1){
                    lastFoundAt = -1;
                    break;
                }else if(mat[i][j] ==1) {
                    lastFoundAt= j;
                }
                
            }
            if(lastFoundAt == -1) continue;
            
             counter += isSpecial(mat, lastFoundAt);
            
        }
       
         
        return counter;
        
    }
}