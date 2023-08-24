//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends





//User function Template for Java



class Solution {
    int count(int[] nums, int n, int target) {
       int low=0, high = nums.length-1;
          int mid =0;
          int left =-1;
        while(low<=high){

        mid=(low+high)/2;
          if(nums[mid]==target){
          left= mid;
          low=mid+1;
          }
          else if(nums[mid]>target)
          {
              high = mid-1;
             
          }
          else
          low=mid+1;
         
        }
          low=0;
           high = nums.length-1;
          mid =0;
          int right =-1;
        while(low<=high){

        mid=(low+high)/2;
          if(nums[mid]==target){
          right= mid;
          high=mid-1;
          }
          else if(nums[mid]>target)
          {
              high = mid-1;
             
          }
          else
          low=mid+1;
         
        }
        if(right !=-1){
            return left-right+1;
        }
        return 0;
    }}