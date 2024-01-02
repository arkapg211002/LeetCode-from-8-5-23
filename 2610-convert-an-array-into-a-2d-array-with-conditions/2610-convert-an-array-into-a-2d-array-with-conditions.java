class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> resultLists = new ArrayList<>();
        Arrays.sort(nums);

        int currentCount = 1, maxCount = 1;
        int currentIndex = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            maxCount = Math.max(currentCount, maxCount);
        }

        for (int j = 0; j < maxCount; j++) {
            resultLists.add(new ArrayList<>());
        }

        resultLists.get(0).add(nums[0]);
        for (int k = 1; k < nums.length; k++) {
            if (nums[k] == nums[k - 1]) {
                currentIndex = currentIndex + 1;
            } else {
                currentIndex = 0;
            }
            if (currentIndex < maxCount) {
                resultLists.get(currentIndex).add(nums[k]);
            }
        }

        return resultLists;
    }
}