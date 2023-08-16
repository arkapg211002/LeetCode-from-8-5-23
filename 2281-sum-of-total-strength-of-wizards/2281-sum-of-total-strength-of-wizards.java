class Solution {
    public int totalStrength(int[] strength) {
        long mod = (long)(1e9 + 7);
        int n = strength.length;
        // prefixSums[I] = sum of STR[0...I]
        long[] prefixSums = new long[n];
        /*
            prefix2Sums is a bit different
            it's not a prefixSum of prefixSums
            
            but rather prefix2Sums[I] = sum of STR[I to I] + STR[I-1 to I] + STR[I-2 to I] + ... STR[0 to I]
            this is used in a very trickly way to compute in constant time:
            a special range(M, I)
            that is STR(M to I) + STR(M+1 to I) + ... + STR(I to I)
        */
        long[] prefix2Sums = new long[n];
        long sum = 0L; // for prefix arrays
        long ans = 0L;
        // contributions[I] = contribution to answer of all arrays ending at I
        long[] contributions = new long[n];
        // monotonic increase (non-decreasing) stack in terms of values of the incides 
        Deque<Integer> indexStack = new ArrayDeque<>();
        long stackScore = 0L;
        for(int i=0; i<n; i++) {
            // build prefix arrays
            sum += strength[i];
            sum = sum % mod;
            prefixSums[i] = sum;
            prefix2Sums[i] = (i == 0)? strength[0] : (prefix2Sums[i-1] + (i+1)*(long)strength[i]) % mod;
            
            while(!indexStack.isEmpty() && strength[indexStack.peekLast()] > strength[i]) {
                // enforce monotonic and adjust stackScore
                int popped = indexStack.removeLast();
                int prevTopIndex = indexStack.isEmpty()? -1 : indexStack.peekLast();
                stackScore -= (((long)strength[popped])*(popped - prevTopIndex) % mod);
            }
            int lastMinIndex = indexStack.isEmpty()? -1 : indexStack.peekLast();
            long contributionAfterLastMinIndex = (long)(strength[i])*
                (prefix2Sums[i] - ((lastMinIndex == -1)? 0 : ((lastMinIndex+1)*(prefixSums[i] - prefixSums[lastMinIndex]) % mod) + prefix2Sums[lastMinIndex]));
            contributionAfterLastMinIndex = (contributionAfterLastMinIndex + mod) % mod;
            long contribution = contributionAfterLastMinIndex;
            if (lastMinIndex != -1) {
                contribution += contributions[lastMinIndex] + (stackScore*(prefixSums[i] - prefixSums[lastMinIndex]) % mod);
                contribution = contribution % mod;
            }
            contributions[i] = (contribution + mod) % mod;
            
            indexStack.addLast(i);
            stackScore += ((long)(strength[i])*(i - lastMinIndex)) % mod;
            stackScore = stackScore % mod;
            
            ans += contributions[i];
            ans = ans % mod;
        }
        return (int)ans;
    }
}