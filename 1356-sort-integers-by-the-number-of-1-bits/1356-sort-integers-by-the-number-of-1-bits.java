class Solution {
    public int[] sortByBits(int[] arr) {
        int t=0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(count(arr[j])>count(arr[j+1]))
                {
                    t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
        return arr;
    }
    public int count(int n)
    {
        int c=0;
        while(n>0)
        {
            n&=(n-1);
            c+=1;
        }
        return c;
    }
}