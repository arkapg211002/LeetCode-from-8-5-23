class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> a = new Stack<>();
        for(String i : tokens){
            if(i.equals("+")){
                int t = a.pop()+a.pop();
                a.push(t);
            }
            else if(i.equals("-")){
                int t =(a.pop()-a.pop())*(-1);
                 a.push(t);
            }
              else if(i.equals("*")){
                int t =a.pop()*a.pop();
                 a.push(t);
            }
             else if(i.equals("/")){
                int x= a.pop();
                int y =a.pop();
                a.push(y/x);
            }
            else{
                int t =  Integer.parseInt(i);
                a.push(t);
            }
        }
        return a.pop();  
    }
}