class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>st=new Stack<>();
        int c=0;
        char arr[]=s.toCharArray();
        for (int i=0;i<arr.length;i++)
        {
            char ch=arr[i];
            if (ch=='(') 
            {
                st.push(c);
                c=0;
            } 
            else 
                c=st.pop()+(int)Math.max(c*2,1);
        }
        return c;
    }
}