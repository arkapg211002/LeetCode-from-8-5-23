class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length == 0) return asteroids;
        Stack<Integer> s = new Stack<>();
        for(int a : asteroids) {
            while(true) 
            {
                if(s.size() == 0) 
                {
                    s.push(a);
                    break;
                } 
                else 
                {
                    int prev = s.peek();
                    if(!(prev > 0 && a < 0)) 
                    {
                        s.push(a);
                        break;
                    }
                    if(Math.abs(prev) == Math.abs(a) ) 
                    {
                        s.pop();
                        break;
                    } 
                    else
                    {
                        if(Math.abs(prev) < Math.abs(a)) s.pop();
                        else if(Math.abs(prev) > Math.abs(a)) break;
                    }
                }
            }
        }
        int n=s.size();
        int arr[] = new int[n];
        while(n > 0) arr[--n] = s.pop();
        return arr;
    }
}