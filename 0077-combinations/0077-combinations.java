class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1,  res, new ArrayList<>());
        return res;
    }
    public void helper(int n, int k, int idex, List<List<Integer>> res, List<Integer> temp)
    {
        if(temp.size()==k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idex; i<=n;i++)
        {
            temp.add(i);
            helper(n, k, i+1, res, temp);
            temp.remove(temp.size()-1);
        }
    }
}