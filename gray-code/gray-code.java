class Solution {
    public List<Integer> grayCode(int n) 
    {
        String[] grayCodes = binaryGrayCodes(n);
        List<Integer> result = new ArrayList<>();
        for(String grayCode: grayCodes)
            result.add(Integer.parseInt(grayCode,2));
        return result;
    }
    public String[] binaryGrayCodes(int n) 
    {
        int total = (int) Math.pow(2,n);
        String[] grayCode = new String[total];
        grayCode[0]="0";
        grayCode[1]="1";
        for(int i=2;i<=n;i++)
        {
            int start = (int) Math.pow(2,i-1);
            for(int j=0;j<start;j++)
            {
                if(grayCode[start-j-1].length()<i-1)
                    grayCode[start-j-1] = "0".concat(grayCode[start-j-1]);
                grayCode[start+j]="1".concat(grayCode[start-j-1]);
            }
        }
        return grayCode;
    }
}