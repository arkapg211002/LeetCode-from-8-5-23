//{ Driver Code Starts
//Initial Template for Java

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
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
         int n = grid.length;
        int m = grid[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        
        List<int[]> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int[] dir : directions) {
                        int row = i;
                        int col = j;
                        int k;
                        
                        for (k = 1; k < word.length(); k++) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            
                            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || grid[newRow][newCol] != word.charAt(k)) {
                                break;
                            }
                            
                            row = newRow;
                            col = newCol;
                        }
                        
                        if (k == word.length()) {
                            result.add(new int[]{i, j});
                            break; // Avoid adding duplicates if the word can be found in multiple directions
                        }
                    }
                }
            }
        }
        
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}