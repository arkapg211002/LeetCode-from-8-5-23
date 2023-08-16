class Solution {
    public int maximumScore(int[] nums, int k) {
        HashMap<Integer,Integer> h1=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> h2=new HashMap<Integer,Integer>();
        int left[]=new int[k+1];
        int right[]=new int[nums.length-k];
        int min=nums[k];
        left[k]=min;
        for(int i=k-1;i>=0;i--)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }
            left[i]=min;
            if(!h1.containsKey(min))
            {
               h1.put(min,i);
            }
        }

        h1.put(nums[k],k);
        min=nums[k];
        right[0]=min;
        int r=1;
        h2.put(min,k);
        for(int j=k+1;j<nums.length;j++)
        {
            if(nums[j]<min)
            {
              min=nums[j];
            }
            right[r]=min;
            if(!h2.containsKey(min))
            {
               h2.put(min,r);
            }
            r++;
        }
     
       int lstart=0,rstart=right.length-1;
       long ans=0;
       while(lstart<=k && rstart>=0)
       {
           int p=left[lstart];
           int q=right[rstart];
           if(p<q)
           {
              long score=1l;
              score=score*(rstart+1+k-lstart)*p;
              if(score>ans)
              {
                  ans=score;
              }
              int x=h1.get(p);
             
                  lstart=x+1;
              
           }
           else if(p==q)
           {
               long score=1l;
               score=score*(rstart+1+k-lstart)*p;
               if(score>ans)
               {
                 ans=score;
               }
               int x=h1.get(p);
               lstart=x+1;
                x=h2.get(q);
                rstart=x-1;
                
           }
           else
           {
               long score=1l;
               score=score*(rstart+1+k-lstart)*q;
               if(score>ans)
               {
                 ans=score;
               }
               int x=h2.get(q);
              rstart=x-1;
                
           }
       }

       return (int)ans;


    }
}