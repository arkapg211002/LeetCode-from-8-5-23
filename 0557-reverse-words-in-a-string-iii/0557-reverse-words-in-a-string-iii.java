class Solution {
    public String reverseWords(String s) {
        String str[]=s.split(" ");
        String f="";
        for(int i=0;i<str.length;i++)
        {
            StringBuilder sb=new StringBuilder(str[i]);
            f+=sb.reverse().toString()+" ";
        }
        f=f.trim();
        return f;
    }
}