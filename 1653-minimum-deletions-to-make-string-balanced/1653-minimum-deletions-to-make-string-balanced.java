class Solution {
    public int minimumDeletions(String st) {
        int res=0,c=0;
        for (int i=0;i<st.length();i++) 
        {
            char ch=st.charAt(i);
            if(ch=='b') c+=1;
            if(c>0 && ch=='a')
            {
                c-=1;
                res+=1;
            }
        }
        return res;
    }
}