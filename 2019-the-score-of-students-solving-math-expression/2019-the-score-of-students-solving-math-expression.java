class Solution {
    HashMap<String , HashSet<Integer>> cache =new HashMap<>();
    public int scoreOfStudents(String s, int[] ans) {
        int sign=1;
        int i=0;
        Stack<Integer>st=new Stack<>();
//correct answer of the equation
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='+'||ch=='*'){
                sign=ch=='+'?1:-1;
                i++;
            }
            else if( Character.isDigit(ch)){
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                if(sign==1)
                    st.add(num);
                else
                    st.add(st.pop()*num);
            }
        }
        int x=0;
        while(st.size()>0)
            x+=st.pop();
    HashSet<Integer>d=recursion(s);//trying to generate all possible answers by placing bractes at different positions
   d.remove(x);
    int res=0;
        for(int z:ans){
            if(z==x)
                res+=5;
            else if(d.contains(z))//set of wrong answers
                res+=2;
        }
        return res;


    }
//Mehtod to generate all wrong answers
    HashSet<Integer> recursion(String a){
        if(cache.containsKey(a))//memoization
            return cache.get(a);
        HashSet<Integer>ans=new HashSet<>();
        for(int i=0;i<a.length();i++){
            char ch=a.charAt(i);
            if(ch=='+'||ch=='*'){//once we encounter a sign
                HashSet<Integer> s1=recursion(a.substring(0,i));
                //we get the number b4 it
               HashSet<Integer> s2=recursion(a.substring(i+1));
                //and the numbers after it and do recursion on each of them
              for(int a1:s1){
                  for(int a2:s2)
                    {
                       
                        if(ch=='+'){
                            if(a1+a2>1000)continue;//optimization
                            ans.add(a1+a2);
                        }
                        else{
                            if(a1*a2>1000)continue;//optimization
                            ans.add(a1*a2);
                        }
                    }
                }

            }
           
        }
         if(ans.size()==0 && a.length()<=1)
                ans.add(Integer.parseInt(a));
           cache.put(a,ans);
           return ans;
    }
}