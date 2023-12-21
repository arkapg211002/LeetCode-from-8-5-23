class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xCoordinates = new int[points.length];
        for (int i = 0; i < points.length; i++) 
            xCoordinates[i] = points[i][0];
        Arrays.sort(xCoordinates);
        int maxWidth = 0;
        for (int i = 1; i < xCoordinates.length; i++) 
            maxWidth = Math.max(maxWidth, xCoordinates[i] - xCoordinates[i - 1]);
        return maxWidth;
    }
}