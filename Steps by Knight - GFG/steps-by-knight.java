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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
    {
        // Code here
        int[][] vis=new int[n][n];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{KnightPos[0]-1,KnightPos[1]-1,0});
        vis[KnightPos[0]-1][KnightPos[1]-1]=1;
        
        int[] dr={-2,-1,1,2,2,1,-1,-2};
        int[] dc={1,2,2,1,-1,-2,-2,-1};
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int row=temp[0];
            int col=temp[1];
            int steps=temp[2];
            if(row==TargetPos[0]-1 && col==TargetPos[1]-1) return steps;
            for(int i=0;i<8;i++){
                int nrow=row+dr[i];
                int ncol=col+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.offer(new int[]{nrow,ncol,steps+1});
                }
            }
        }
        return -1;
    }
}