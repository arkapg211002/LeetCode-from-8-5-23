class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        String st[]=s.split(" ");
        return st[st.length-1].length();
    }
}