//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] arr, int n)
           {
                  //add code here.
                  for(int i=0;i<n;i++)
                  {
                      StringBuilder sb=new StringBuilder(Integer.toString(arr[i]));
                      String s1=sb.toString();
                      String s2=sb.reverse().toString();
                      if(s1.equals(s2)==false) return 0;
                  }
                  return 1;
           }
}