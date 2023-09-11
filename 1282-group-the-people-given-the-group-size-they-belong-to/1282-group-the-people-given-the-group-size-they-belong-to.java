class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // Create a HashMap to map group sizes to lists of people.
        HashMap<Integer, List<Integer>> groupMapping = new HashMap<Integer, List<Integer>>();
        
        // Initialize a list to store the final result.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Iterate through the groupSizes array.
        for (int i = 0; i < groupSizes.length; i++) {
            // Get the list of people for the current group size from the mapping.
            List<Integer> currentGroup = groupMapping.getOrDefault(groupSizes[i], new ArrayList<Integer>());
            
            // Check if the current group is full (size matches the specified group size).
            if (currentGroup.size() == groupSizes[i]) {
                // If the group is full, add it to the result and create a new empty group.
                result.add(currentGroup);
                currentGroup = new ArrayList<Integer>();
            }
            
            // Add the current person (index 'i') to the current group.
            currentGroup.add(i);
            
            // Update the mapping with the current group.
            groupMapping.put(groupSizes[i], currentGroup);
        }
        
        // After processing all people, add the remaining groups to the result.
        for (int size : groupMapping.keySet()) {
            result.add(groupMapping.get(size));
        }
        
        // Return the final list of groups.
        return result;
    }
}