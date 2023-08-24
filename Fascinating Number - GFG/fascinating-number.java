//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();

        int T = sc.nextInt();

        while (T != 0) {
            long n = sc.nextLong();
            if (ob.fascinating(n))
                System.out.println("Fascinating");
            else
                System.out.println("Not Fascinating");
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean fascinating(long n) {
        // code here
        long x=n*2;
        long y=n*3;
        boolean flag=true;
        //String s=String.valueOf(x)+String.valueOf(y)+String.valueOf(n);
        String s=""+x+y+n;
        if(s.length()==9){
            HashMap<Character,Integer>h=new HashMap<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch>='1' && ch<='9'){
                    if(!h.containsKey(s.charAt(i))){
                        h.put(s.charAt(i),1);
                    }
                    else{
                        flag=false;
                        break;
                    }
                }
                else{
                    flag=false;
                    break;
                }
            }
        }
        else
        flag=false;
        
        return flag;
    }
}