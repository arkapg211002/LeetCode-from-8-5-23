class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while(i<sb.length()-1){
            if(sb.charAt(i)=='A'&&sb.charAt(i+1)=='B'){
                sb.delete(i,i+2);
                i=Math.max(0,i-1);
            }
            else if (sb.charAt(i)=='C'&&sb.charAt(i+1)=='D'){
                sb.delete(i,i+2);
                i=Math.max(0,i-1);
            }else{
                i++;
            }
        }return sb.length();
        
    }
}