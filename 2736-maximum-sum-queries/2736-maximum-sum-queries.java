class Solution {
    public int[] maximumSumQueries(int[] a1, int[] a2, int[][] queries) {
        int n = a1.length;
        int a[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            a[i][0] = a1[i];
            a[i][1] = a2[i];
        }
        Arrays.sort(a2);
        hm = new TreeMap<>();
        int k = 0;
        for(int i = 0; i < n; i++)
            if(!hm.containsKey(a2[i]))
                hm.put(a2[i], k++);
        
        Arrays.sort(a, 
            new Comparator<int[]>(){
                public int compare(int x[], int y[]){
                    return x[0] - y[0];
                }
            }
        );
        
        for(int i = 0; i < queries.length; i++){
            queries[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(queries,
            new Comparator<int[]>(){
                public int compare(int x[], int y[]){
                    return -x[0] + y[0];
                }
            }
        );
        int max = 0;
        int ans[] = new int[queries.length];
        int j = 0;
        int i = a.length - 1;
        
        seg = new int[4 * hm.size() + 4];
        Arrays.fill(seg, -1);
        while(j < queries.length){
            while(i > -1 && a[i][0] >= queries[j][0]){
                update(0, hm.size() - 1, hm.get(a[i][1]), a[i][0] + a[i][1], 0);
                i--;
            }
            
            if(hm.ceilingKey(queries[j][1]) == null){
                ans[queries[j][2]] = -1;
            } else{
                ans[queries[j][2]] = find(0, hm.size() - 1, hm.ceilingEntry(queries[j][1]).getValue(), hm.size() - 1, 0);
            }
            j++;
        }
        while(j < queries.length)
            ans[queries[j++][2]] = -1;
        return ans;
    }
    private void update(int low, int high, int ind, int val, int node){
        if(low == high){
            seg[node] = Math.max(seg[node], val);
            return;
        }
        int mid = (low + high) >> 1;
        if(ind <= mid)
            update(low, mid, ind, val, 2 * node + 1);
        else
            update(mid + 1, high, ind, val, 2 * node + 2);
        seg[node] = Math.max(seg[2 * node + 1], seg[2 * node + 2]);
    }
    private int find(int low, int high, int l, int r, int node){
        if(low > r || high < l)
            return -1;
        if(low >= l && high <= r)
            return seg[node];
        int mid = (low + high) >> 1;
        return Math.max(find(low, mid, l, r, 2 * node + 1), find(mid + 1, high, l, r, 2 * node + 2));
    }
    private int seg[];
    private TreeMap<Integer, Integer> hm;
}