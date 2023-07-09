public class Solution {
    public int largestVariance(String s) {
        int[] arr = new int[26];
        for (char x : s.toCharArray()) {
            arr[x - 'a']++;
        }
        int ans = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == i || arr[i - 'a'] == 0 || arr[j - 'a'] == 0)
                    continue;
                for (int k = 1; k <= 2; k++) {
                    int A1 = 0;
                    int A2 = 0;
                    for (char x : s.toCharArray()) {
                        if (x == i)
                            A1++;
                        if (x == j)
                            A2++;
                        if (A2 > A1) {
                            A1 = 0;
                            A2 = 0;
                        }
                        if (A1 > 0 && A2 > 0)
                            ans = Math.max(ans, A1 - A2);
                    }
                    s = new StringBuilder(s).reverse().toString();
                }
            }
        }
        return ans;
    }
}
