//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Scanner;
  
public class GFG { 
    
  
    public static void main(String[] args) 
    { 
        Scanner sc = new Scanner(System.in);
        
        //Taking the number of testcases
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
             Solution g=new Solution();
            
            Queue<Integer> ans=g.push(arr,n);
            g._pop(ans);
            System.out.println();
            
        }
  
        
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution{
    Queue<Integer> q=new LinkedList<>();
    public Queue<Integer> push(int arr[], int n)
    {
        //push all the elements of the array arr in the queue and return the queue
        for(int i=0;i<n;i++) q.add(arr[i]);
        return q;
    }
    
    public void _pop(Queue<Integer> q)
    {
        //dequeue the elements and print them
        int n=q.size();
        for(int i=0;i<n;i++) System.out.print(q.remove()+" ");
    }
}