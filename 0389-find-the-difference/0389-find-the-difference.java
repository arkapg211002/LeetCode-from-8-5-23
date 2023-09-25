class Solution {
    public char findTheDifference(String s, String t) {
       int[] chars = new int[123];
        
        for(int i=0;i<s.length();i++)
            chars[s.charAt(i)]++;
        for(int i=0;i<t.length();i++)
            if(chars[t.charAt(i)]-- == 0)
                return t.charAt(i);
                
        return ' ';
    }
}