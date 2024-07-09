// https://leetcode.com/problems/average-waiting-time/description/?envType=daily-question&envId=2024-07-09

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int finishTime = customers[0][0];
        for(int[] cust: customers ){
            if(cust[0] <= finishTime){ 
            finishTime += cust[1];
            }
            else{
                finishTime = cust[0] + cust[1];
            }
            cust[1] = finishTime;
        }
        long totalWaitingTime = 0;
        for(int[] cust: customers ){
            totalWaitingTime += (cust[1] -cust[0]); 
        }
        return totalWaitingTime/((double)customers.length);
    }
}
