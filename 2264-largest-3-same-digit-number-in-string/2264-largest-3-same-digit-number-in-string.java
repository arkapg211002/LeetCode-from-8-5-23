class Solution {
    public String largestGoodInteger(String num) {
        String []ans={"000","111","222","333","444","555","666","777","888","999"};
        int n=num.length()-3;
        String m="";
        int con=0;
        for(int i=0;i<=n;i++)
        {
            int t=Character.getNumericValue(num.charAt(i));
            
            if((ans[t].compareTo(num.substring(i,i+3)))==0)
            {
                if(con==0){
                m=ans[t];
                    con=1;
                }
                else
                {
                    int o=Integer.parseInt(ans[t]);
                    int k=Integer.parseInt(m);
                    if(k<o)
                    {
                        m=ans[t];
                    }
                }
                con=1;
                
                
            }
        }
        return m;
    }
}