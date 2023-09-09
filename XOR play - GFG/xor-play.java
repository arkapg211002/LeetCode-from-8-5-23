//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.xor_play(n);
            for(int i = 0; i < ans.length - 1; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println(ans[ans.length - 1]);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] xor_play(int n)
    {
        // code here
        if(n==1){ return new int[]{0}; }
        ArrayList<Integer> list=new ArrayList<>();
        int zor=1;
        int k=(int)Math.sqrt(n);
        boolean bool=false;
        if(k*k==n){ bool=true; zor^=k; k--; }
        for(int i=2; i<=k; i++){
            if(n%i==0){ 
                list.add(i); list.add(n/i);
                zor^=i; zor^=n/i;
            }    
        }
        int len=list.size()+2;
        if(bool){ len++; }
        int[] arr=new int[len];
        int j=0;
        arr[j]=1; j++;
        for(int i=0; i<list.size(); i++){
            if(i%2==0){ arr[j]=list.get(i); j++; }
        }
        if(bool){ arr[j]=k+1; j++; }
        for(int i=list.size()-1; i>=0; i--){
            if(i%2==1){ arr[j]=list.get(i); j++; }
        }
        arr[j]=zor;
        return arr;
    }
}
    
