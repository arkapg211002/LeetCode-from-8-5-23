//{ Driver Code Starts
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
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>(); 
            for( int i = 0; i < n; i++)
            {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);

        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int findPeakElement(List<Integer> a)
    {
        // Code here
        int peak=-1;
        int l=0;
        int h=a.size()-1;
        int n=a.size();
        while(l<=h){
            int mid=h+(l-h)/2;
            int prev=(mid-1+n)%n;
            int next=(mid+1)%n;
            
            if((a.get(mid)>a.get(prev))  &&(a.get(mid)>a.get(next)))
            {
                peak=a.get(mid);
                break;
            }
            else if(a.get(mid)<a.get(next)){
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return peak;
    }
}