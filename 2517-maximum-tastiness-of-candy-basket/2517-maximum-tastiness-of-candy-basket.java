class Solution {
    public int maximumTastiness(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);
        int left = 0;
        int right = 1000000000;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (tasty(price, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (tasty(price, right, k)) {
            return right;
        }
        return left;
    }
    private boolean tasty(int[] price, int target, int k) {
        int prev = price[0];
        int count = 1;
        int index = 1;
        while (count < k && index < price.length) {
            if (price[index] - prev >= target) {
                prev = price[index];
                count++;
            }
            index++;
        }
        return count == k;
    }
}
