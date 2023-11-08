public class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        // Calculate the Manhattan distance between the start and target cells
        int xDistance = Math.abs(sx - fx);
        int yDistance = Math.abs(sy - fy);
        
        // Calculate the minimum distance required to reach the target
        int minDist = Math.min(xDistance, yDistance) + Math.abs(yDistance - xDistance);
        
        // If the minimum distance is 0, it's not possible to reach within 1 second
        if (minDist == 0) {
            return t != 1;
        }
        
        // Check if the given time is greater than or equal to the minimum distance
        return t >= minDist;
    }
}
