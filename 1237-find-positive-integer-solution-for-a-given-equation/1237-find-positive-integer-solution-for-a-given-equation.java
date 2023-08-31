class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= 1000; ++i) {
            int x = 1, y = 1000;
            while (x < y) {
                int mid = (x + y) >> 1;
                if (customfunction.f(i, mid) >= z) {
                    y = mid;
                } else {
                    x = mid + 1;
                }
            }
            if (customfunction.f(i, x) == z) {
                result.add(Arrays.asList(i, x));
            }
        }
        return result;
    }
}