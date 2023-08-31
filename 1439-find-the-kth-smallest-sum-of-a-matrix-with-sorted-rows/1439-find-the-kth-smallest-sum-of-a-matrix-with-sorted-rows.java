class Solution {
    public int kthSmallest(int[][] mat, int k) {

List<Integer> p= new ArrayList();

   for(int i=0;i<mat[0].length;i++){
    p.add(mat[0][i]);
}

     for(int i=1;i<mat.length;i++){
         int a[]=mat[i];
         List<Integer> q= new ArrayList();
         for(int m:p){
             for(int n:a){
                 q.add(m+n);
             }
         }
         Collections.sort(q);
         p.clear();
        for(int j=0;j<Math.min(k,q.size());j++){
            p.add(q.get(j));
        } 
     }             
             return p.get(p.size()-1);     
    }
}