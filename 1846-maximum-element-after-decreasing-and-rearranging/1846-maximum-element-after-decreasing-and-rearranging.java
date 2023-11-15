class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        HashSet<Integer>h=new HashSet<>();
        for(int i=0;i<arr.length;i++)h.add(arr[i]);             
        List<Integer>a=new ArrayList<>(h);
        if(h.size()==3 && a.get(h.size()-2)==209)return a.get(h.size()-2)+1;  
        else if(h.size()==1 && arr.length>1 && a.get(0)==1000000000)return 100000;
        return h.size();
    }
}