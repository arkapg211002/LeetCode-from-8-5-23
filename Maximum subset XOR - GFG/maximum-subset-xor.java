//{ Driver Code Starts
import java.util.*;

import java.io.*;
class XOR
{	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0)
		{
		  int n = Integer.parseInt(br.readLine().trim());
		  String s[] = br.readLine().trim().split(" ");
		  int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=Integer.parseInt(s[i]);
		  Solution g = new Solution();
		  System.out.println(g.maxSubsetXOR(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/

class Solution
{
    public static int maxSubsetXOR(int set[], int n)
    {
        //add code here.
        int index = 0;

        // Traverse through all bits of integer starting from the most significant bit (MSB)
        for (int i = 31; i >= 0; i--) {
            // Initialize index of maximum element and the maximum element
            int maxInd = index;
            int maxEle = Integer.MIN_VALUE;
            for (int j = index; j < n; j++) {
                // If i'th bit of set[j] is set and set[j] is greater than max so far
                if ((set[j] & (1 << i)) != 0 && set[j] > maxEle) {
                    maxEle = set[j];
                    maxInd = j;
                }
            }

            // If there was no element with i'th bit set, move to smaller i
            if (maxEle == Integer.MIN_VALUE)
                continue;

            // Swap set[index] and set[maxInd]
            int temp = set[index];
            set[index] = set[maxInd];
            set[maxInd] = temp;

            // Update maxInd and increment index
            maxInd = index;

            // Do XOR of set[maxIndex] with all numbers having i'th bit as set
            for (int j = 0; j < n; j++) {
                // XOR set[j] with set[maxInd] if j != maxInd and j'th bit of set[j] is set
                if (j != maxInd && (set[j] & (1 << i)) != 0)
                    set[j] = set[j] ^ set[maxInd];
            }

            // Increment index of chosen elements
            index++;
        }

        // Final result is XOR of all elements
        int res = 0;
        for (int i = 0; i < n; i++)
            res ^= set[i];
        return res;
    }
}