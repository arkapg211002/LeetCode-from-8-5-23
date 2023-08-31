//{ Driver Code Starts
import java.util.*;

class Triplet
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
            GfG gfg = new GfG();
           ArrayList<Integer> res = new ArrayList<Integer>();
           res = gfg.findTriplet(arr, n);
            if(res.size()!=3)System.out.println("-1");
	    else
	    {
	        Collections.sort(res);
	        if(res.get(0)+res.get(1) == res.get(2))
	            System.out.println("1");
	        else
	             System.out.println("0");
	    }
           //System.out.println();
            
        }
    }
}

// } Driver Code Ends


class GfG
{
    public static ArrayList<Integer> findTriplet(int arr[], int n)
    {
        // your code here
        // int count=0;
        ArrayList<Integer> result=new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                // count=0;
                int sum=arr[i]+arr[j];
                    if(sum==arr[k]){
                    // count++;
                    result.add(arr[i]);
                    result.add(arr[j]);
                    result.add(arr[k]);
                    return result;
                    }
                }
            }
        }
        return result;
        
    }
}