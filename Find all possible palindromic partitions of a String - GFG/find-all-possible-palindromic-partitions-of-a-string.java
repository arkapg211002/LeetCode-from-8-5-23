//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>>result=new ArrayList<>();
        
        findPalin(S,list,result,0);
        return result;
        
    }
    static void findPalin(String s , ArrayList<String>list , ArrayList<ArrayList<String>>result,int Index)
    
    {
        if(Index==s.length())
        {
            result.add(new ArrayList<>(list));
            
            return ;
        }
        String temp="";
        
        for(int i=Index;i<s.length();i++)
        {
            temp+=s.charAt(i);
            
            if(isPalin(temp))
            {
                list.add(temp);
                
                findPalin(s,list,result,i+1);
                
                list.remove(list.size()-1);
                
            }
         
        }
        
    }
    
    static boolean isPalin(String str)
    {
        if(str.length()<2)
        return true;
        
        
        
        int start=0;
        int end=str.length()-1;
        
        while(start<end)
        {
            if(str.charAt(start)!=str.charAt(end))
            return false;
            
            start++;
            end--;
        }
        return true;
    
    }
};

