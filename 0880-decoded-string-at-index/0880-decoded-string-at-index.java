class Solution {
    public String decodeAtIndex(String s, int k) {
        int len =0,next=0;
        while (k>0) {
            if (Character.isDigit(s.charAt(next))){
                int inc = len;
                for (int i=1;i<s.charAt(next)-'0';i++){
                    if (inc<k) {
                        len+=inc;
                        k -=inc;
                    }
                    else return decodeAtIndex (s,k);
                }
            }
            else {
                k--;
                len++;
            }
            next++;
        }   
        return ""+ s.charAt(next - 1);
    }
}