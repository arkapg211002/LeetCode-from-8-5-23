class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        int id=s.length()/2;
        String l=s.substring(0,id);
        //System.out.println(l);
        String r=s.substring(id);
        //System.out.println(r);
        if(v(l)==v(r))return true;
        else return false;
    }
    public static int v(String s)
    {
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')c+=1;
        }
        return c;
    }
}