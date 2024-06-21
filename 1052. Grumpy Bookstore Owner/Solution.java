// https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=daily-question&envId=2024-06-21

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
      int satisfied = 0;
      for(int i = 0; i < customers.length; i++)
        if(grumpy[i] == 0) satisfied += customers[i];
      int left = 0, bonus =0;
      for(int i = 0; i< minutes ; i++)
        if(grumpy[i] == 1) bonus+= customers[i]; 
      int curBonus = bonus;
      for(int right = minutes; right < customers.length; right++)
      {
        if(grumpy[left] == 1) curBonus -= customers[left];
        left++;
        if(grumpy[right] == 1) curBonus+= customers[right];
        bonus = Math.max(bonus,curBonus); 
      }
      return satisfied+bonus;
    }
}
