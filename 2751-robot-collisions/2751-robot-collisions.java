class Solution {
    class Pair{
        int p;
        int h;
        char d;
        int idx;
        Pair(int p,int h,char d,int i){
            this.p=p;
            this.h=h;
            this.d=d;
            this.idx=i;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
          int n=positions.length;
          List<Pair> list=new ArrayList<>();
        
          for(int i=0;i<n;i++){
              list.add(new Pair(positions[i],healths[i],directions.charAt(i),i));
          }
        
          Collections.sort(list,(a,b)->a.p-b.p);
        
          List<int[]> ans=new ArrayList<>();
          Stack<int[]> q=new Stack<>();
        
          for(int i=0;i<n;i++){
              Pair curr=list.get(i);
              if(curr.d=='R'){
                  q.add(new int[]{curr.h,curr.idx});
                  continue;
              }
              else{
                  boolean flag=false;
                  int health=curr.h;
                  
                  while(!q.isEmpty() && health!=0){
                       int top[]=q.pop();
                       int last=top[0];
                       int idx=top[1];
                      
                       if(last<health){
                           health-=1;
                       }else if(last==health){
                           health=0;
                           break;
                       }
                       else{
                          last-=1;
                          health=0;
                          q.add(new int[]{last,idx});
                           
                       }
                  }
                  
                  if(health!=0)
                      ans.add(new int[]{health,curr.idx});
              }
          }
        
        while(!q.isEmpty()){
              ans.add(q.pop());
        }
        
        Collections.sort(ans,(a,b)->a[1]-b[1]);
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<ans.size();i++){
            result.add(ans.get(i)[0]);
        }
        
        return result;
    }
}