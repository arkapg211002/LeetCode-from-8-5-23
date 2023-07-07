class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int Tmax = solve(answerKey, k, 'T');
        int Fmax = solve(answerKey, k, 'F');

        return Math.max(Tmax, Fmax);
    }

    private int solve(String answerKey, int k, char opt) {
        int maxi = -1;
        int n = answerKey.length();
        int k2 = 0, i = 0;
        for (int j = 0; j < n; j++) {
            if (answerKey.charAt(j) != opt)
                k2++;
            while (k2 > k) {
                if (answerKey.charAt(i) != opt)
                    k2--;
                i++;
            }
            maxi = Math.max(j - i + 1, maxi);
        }
        return maxi;
    }
}