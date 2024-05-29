// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/?envType=daily-question&envId=2024-05-29

class Solution {

    private void divide(StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
    }

    private void add(StringBuilder s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }

        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);

        int count = 0;
        while (sb.length() > 1) {

            if (sb.charAt(sb.length() - 1) == '0') {
                divide(sb);
            } else {
                add(sb);
            }

            count ++;
        }

        return count;
    }
}
