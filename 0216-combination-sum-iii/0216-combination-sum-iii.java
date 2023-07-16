class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n <= k || n > 55) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        goBackTracking(1, new ArrayList<>(), result, k, n, 0);
        return result;
    }
    public void goBackTracking(int i, List<Integer> list, List<List<Integer>> result, int k, int sum, int tempSum) 
    {
        if (list.size() == k && tempSum == sum) 
        {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < 10; j++) 
        {
            list.add(j);
            goBackTracking(j + 1, list, result, k, sum, tempSum + j);
            list.remove(list.size() - 1);
        }
    }
}