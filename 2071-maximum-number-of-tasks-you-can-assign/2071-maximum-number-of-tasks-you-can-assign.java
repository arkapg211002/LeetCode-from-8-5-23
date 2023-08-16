class Solution {
    public int maxTaskAssign(int[] t, int[] w, int p, int s) {
        int n = w.length;
        int m = t.length;
        Arrays.sort(t);
        
        int lo = 1, hi = Math.min(n, m);  // hi = Math.min(n, m),  since max tasks you can assign is the minimum of tasks and workers
        int ans = 0;
		// binary search to find the max tasks we can assign
        while(lo <= hi){
            int mid = (lo+hi)>>1;
            if(check(t, w, p, s, mid)){ 
                ans = mid;
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return ans;
    }
    
    boolean check(int []t, int w[], int p, int s, int n){
        int idx = n-1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        addAll(w, map);
        
        while(idx >= 0){
            Integer strongest = map.ceilingKey(t[idx]);  // try assigning the task to the strongest worker
            if(strongest == null){
                if(p == 0) return false;
                Integer weekest = map.ceilingKey(t[idx]-s);  // try assigning the task to the weekest worker with pill
                if(weekest == null) return false; // if cannot assign the task  return false
                remove(map, weekest);
                p--;
            }else{
                remove(map, strongest);
            }
            idx--;
        }
        return true;  // if all k tasks are assigned then return true
    }
    
    void addAll(int[] w, TreeMap<Integer, Integer> map){
        for(int i: w) map.put(i, map.getOrDefault(i, 0) + 1);
    }
    
    void remove(TreeMap<Integer, Integer> map, int val){
        if(map.get(val) == 1) map.remove(val);
        else map.put(val, map.get(val)-1);
    }
}