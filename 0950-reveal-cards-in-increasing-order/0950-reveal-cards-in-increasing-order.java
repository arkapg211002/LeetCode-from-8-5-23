class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q=new LinkedList<>();
        int a[]=new int[deck.length];
        Arrays.sort(deck);
        for(int i=0;i<deck.length;i++)
        {
            q.offer(i);
        }
        int i=0;
        int dee=0;
        while(q.size()!=0)
        {
         if(dee==0)
         {
             a[q.poll()]=deck[i++];
         }  
         else{
            q.add(q.poll()); 
         }
         dee=dee^1;
        
        }
        return a;
    }
}