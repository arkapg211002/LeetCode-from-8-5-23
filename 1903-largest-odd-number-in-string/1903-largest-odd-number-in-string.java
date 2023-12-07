class Solution {
    public String largestOddNumber(String num) {
        if(Integer.valueOf(Character.toString(num.charAt(num.length()-1)))%2!=0)return num;
        String p="";
        for(int i=num.length()-1;i>=0;i--)
        {
            if(Integer.valueOf(Character.toString(num.charAt(i)))%2==0)
            {
                p=num.substring(0,i);
            }
            else break;
        }
        return p;
    }
}