class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        
        // Initialize two arrays to store the maximum elements from the left side
        // and the minimum elements from the right side for each index in the original array.
        int maxleftarr[] = new int[n];
        int minrightarr[] = new int[n];

        // Calculate the maximum elements from the left side of the array.
        maxleftarr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxleftarr[i] = Math.max(maxleftarr[i - 1], arr[i]);
        }

        // Calculate the minimum elements from the right side of the array.
        minrightarr[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minrightarr[i] = Math.min(minrightarr[i + 1], arr[i]);
        }

        int ans = 0;// keep track of the number of chunks found so far.

        // Compare the maximum element from the left side (maxleftarr[i]) with the minimum element
        // from the right side (minrightarr[i+1]) for each index i in the array.
        // If the maximum element from the left side is less than or equal to the minimum element
        // from the right side for a given index, it means we can split the array into chunks at that index.
        // Increment the ans variable to count the number of chunks.
        for (int i = 0; i < n - 1; i++) {
            if (maxleftarr[i] <= minrightarr[i + 1]) {
                ans++;
            }
        }

        // The ans variable will contain the number of chunks found, but we need to add 1 to get the final result,
        // as the initial array itself is a chunk.
        return ans + 1;
    }
}