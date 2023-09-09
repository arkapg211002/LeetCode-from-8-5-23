//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().repeatingEven(arr, n);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] repeatingEven(int[] arr, int n) {
        // code here
        int fre,i;
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        hmap.put(arr[0],0);
        for(i=0;i<n;i++)
        {
            boolean keyExist = hmap.containsKey(arr[i]);
            if(keyExist)
            {
                fre=hmap.get(arr[i]);fre=fre+1;
                hmap.put(arr[i],fre);
            }
            else
                hmap.put(arr[i],1);
        }
        ArrayList<Integer>re=new ArrayList<Integer>();
         for(i=0; i<n; i++){
       if(hmap.containsKey(arr[i])){
           if(hmap.get(arr[i])%2==0){
             re.add(arr[i]);
             hmap.remove(arr[i]);
           }
       }   
      }
      Collections.sort(re);
    
       if(re.size()==0){
          re.add(-1);
      }
      int a[] = new int[re.size()];
      
      for(i=0; i<re.size(); i++){
          a[i]=re.get(i);
          
      }
     
       return a;
    }
}
