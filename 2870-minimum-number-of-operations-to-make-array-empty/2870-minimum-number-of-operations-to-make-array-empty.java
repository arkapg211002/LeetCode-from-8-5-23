class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) freq.put(num, freq.getOrDefault(num, 0) + 1);
        int op = 0;
        for (int e : freq.values()) {
            if (e == 1) return -1;
            op += (e / 3) + (e % 3 != 0 ? 1 : 0);
        }
        return op;
    }
}