// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/

class Solution {
    Map<Integer, Integer> hashMap = new HashMap<>();
    int maximumLength = Integer.MIN_VALUE;
    public int maximumLength(int[] nums) {
        int length = 0;
        for(Integer number : nums) 
        {
            int freq = hashMap.getOrDefault(number, 0);
            hashMap.put(number, freq + 1);
        }
        for(Integer key : hashMap.keySet()) 
        {
            int power = 1;
            int nextKey = (int) Math.pow(key, power);
            while(hashMap.containsKey(nextKey)) 
            {
                if(hashMap.get(nextKey) >= 2) 
                {
                    if(length == 0 && key == 1) length = hashMap.get(nextKey);
                    else length += 2;
                } 
                else 
                {
                    length += 1;
                    break;
                }
                power *= 2;
                nextKey = (int) Math.pow(key, power);
                if(nextKey == 1) break; 
            }
            if(length > maximumLength) maximumLength = length;
            length = 0;
        }
        if(maximumLength % 2 == 0) return (maximumLength - 1);
        else return (maximumLength);
    }
}
