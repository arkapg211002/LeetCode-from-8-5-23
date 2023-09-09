//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.binaryPreviousNumber(s));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
   String binaryPreviousNumber(String S)
       {
           char arr[] = S.toCharArray();
           char SM1[] = new char[S.length()];
           char carry = '0';
           for(int i=S.length()-1;i>=0;--i) {
               if(arr[i]=='1') {
                   if(carry=='0') {
                       SM1[i] = '0';
                       carry = '1';
                   }
                   else if(carry=='1') {
                       SM1[i] = '1';
                       carry = '1';
                   }
               }
               else if(arr[i]=='0') {
                   if(carry=='1') {
                       SM1[i] = '0';
                       carry = '1';
                   }
                   else if(carry=='0') {
                       SM1[i] = '1';
                       carry = '0';
                   }
               }
           }
           String lZs = String.valueOf(SM1);
           try {
               lZs = lZs.substring(lZs.indexOf("1"));
           } catch(StringIndexOutOfBoundsException SIOOBe) {
               return "0";
           }
           return lZs;
       }
}