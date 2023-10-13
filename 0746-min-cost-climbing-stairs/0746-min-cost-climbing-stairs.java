class Solution {
    public int minCostClimbingStairs(int[] cost) {
                int[]steps = new int[cost.length + 1];
        steps[1] = cost[0];
        for (int i = 2; i < steps.length; i++)
            steps[i] = Math.min(steps[i - 2] + cost[i - 1], steps[i - 1] + cost[i - 1]);
        return Math.min(steps[steps.length - 1], steps[steps.length - 2]);
    }
}