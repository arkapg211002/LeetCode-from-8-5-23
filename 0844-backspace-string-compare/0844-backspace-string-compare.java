class Solution {
    public boolean backspaceCompare(String s, String t) {
        return toStack(s).equals(toStack(t));
    }
    
    public Stack<Character> toStack(String s){
        Stack<Character> sStack = new Stack<>();
        String results = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '#'){
                sStack.add(s.charAt(i));
            }else{
                if(sStack.size() != 0)
                    sStack.pop();
            }
        }
        
        return sStack;
    }
}