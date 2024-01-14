class Solution {
    // Check for the current binary search query
    private boolean valid(long mid, long x, long k) {
        // Number of 1's in required bit positions up to the number mid
        long sum = 0;
        for (long i = x - 1; i <= 60; i += x) {
            // Calculate the dividend and pattern size
            long dividend = mid + 1;
            long patsize = (1L << (i + 1));

            // Calculate the sum based on pattern size and dividend
            sum += patsize / 2 * (dividend / patsize);

            // Handle the remainder
            long rem = dividend % patsize;
            if (rem <= patsize / 2) continue;
            rem %= (patsize / 2);
            sum += rem;
        }
        // Return true if the sum is less than or equal to k
        return sum <= k;
    }

    // Perform binary search to find the maximum number
    public long findMaximumNumber(long k, int x) {
        // Initialize the binary search range
        long low = 1, high = (long) 1e15, mid;

        // Binary search loop
        while (low <= high) {
            mid = low + (high - low) / 2;

            // Check if the current mid is valid, update the search range accordingly
            if (valid(mid, x, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Return the maximum number found
        return high;
    }
}