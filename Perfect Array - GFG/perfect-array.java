//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    if(obj.checkUnimodal(arr,n))
		        System.out.println("Yes");
		    else
		        System.out.println("No");
		        
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    static boolean checkUnimodal(int arr[], int n) 
    { 
        // Complete the function
        int a=arr[0]>0 ? 1:0;
        int b=0;
        int c=0;
        int i=0;
        while(i<n-1 && arr[i]<arr[i+1]) 
        {
            a+=1;
            i+=1;
        }
        while(i<n-1 && arr[i]==arr[i+1])
        {
            b+=1;
            i+=1;
        }
        while(i<n-1 && arr[i]>arr[i+1])
        {
            c+=1;
            i+=1;
        }
        if(a+b+c==n) return true;
        else return false;
    } 
}

