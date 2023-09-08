class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList();
        List<Integer> prev=new ArrayList();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> list=new ArrayList();
            list.add(1);
            for(int j=1;j<i;j++)
            {
                int num=prev.get(j)+prev.get(j-1);
                list.add(num);
            }
            if(i>0)
            list.add(1);
            prev=list;
            ans.add(prev);
        }
        return ans;
    }
}