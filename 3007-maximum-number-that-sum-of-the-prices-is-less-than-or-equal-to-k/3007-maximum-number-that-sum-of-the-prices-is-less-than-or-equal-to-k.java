class Solution {
    private boolean valid(long mid, long x, long k) {
        // number of 1's in required bit positions up to the number mid
        long sum = 0;
        for (long i = x - 1; i <= 60; i += x) {
            long dividend = mid + 1;
            long patsize = (1L << (i + 1));
            sum += patsize / 2 * (dividend / patsize);
            long rem = dividend % patsize;
            if (rem <= patsize / 2) continue;
            rem %= (patsize / 2);
            sum += rem;
        }
        return sum <= k;
    }

    public long findMaximumNumber(long k, int x) {
        // binary search
        long low = 1, high = (long) 1e15, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (valid(mid, x, k)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}