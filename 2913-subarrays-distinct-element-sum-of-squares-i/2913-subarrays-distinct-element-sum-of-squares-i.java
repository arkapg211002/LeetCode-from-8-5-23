class Solution {
    public int sumCounts(List<Integer> nums) {
        int total=0;
        
        for(int i=0;i<nums.size();i++){
            total+=1;
            HashSet<Integer>set=new HashSet<>();
            set.add(nums.get(i));
            for(int j=i+1;j<nums.size();j++){
                // System.out.print(total+" ");
                    set.add(nums.get(j));
                    total+=(set.size()*set.size());    
                
            }
            
            // System.out.println();
        }
        
        return total;
    }
}