class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int ans[] = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) 
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < k; i++) 
            ans[i] = entryList.get(i).getKey();
        return ans;
    }
}