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
                    System.out.println(ob.binaryNextNumber(s));
                }
        }
}    
// } Driver Code Ends




//User function Template for Java

class Solution
{
  String binaryNextNumber(String S)
    {
        char[] chars = S.toCharArray();
        boolean flag = false;
        String bin = "";
        for (int i = chars.length - 1; i >= 0; i--)
        {
            if (chars[i] == '0')
            {
                chars[i] = '1';
                flag = true;
                break;
            }
            else
                chars[i] = '0';
        }

        bin = String.valueOf(chars);
        
        if (!flag)
        {
            bin = "1" + bin;
            return bin;
        }
            
        int i = 0;
        while (bin.charAt(i) == '0')
            i++;
        
        return bin.substring(i);
    }
    
}