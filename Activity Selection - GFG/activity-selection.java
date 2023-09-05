//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends


class Solution {
    public static int activitySelection(int start[], int end[], int n) {
        Pair x[] = new Pair[n];
        
        for(int i = 0; i < n; i++){
            x[i] = new Pair(start[i], end[i]);
        }
        
        Arrays.sort(x, new Comparator<Pair>(){
        @Override
        public int compare(Pair a, Pair b)
        {
            return a.f - b.f;
        }
        });
        
        int last = 0;
        int res = 0;

        for (int i = 0; i < end.length; i++) {
            if(x[i].s > last){
                res++;
                last = x[i].f;
            }
        }
    return res;
    }
}
class Pair{
    int s;
    int f;
    
    public Pair(int s, int f){
        this.s = s;
        this.f = f;
    }
}
