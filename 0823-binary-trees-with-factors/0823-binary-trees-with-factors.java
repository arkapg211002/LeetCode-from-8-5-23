class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long [] dp = new long[arr.length];
        Arrays.fill(dp,1);
        long MOD=(int)1e9+7,ans=1;
        dp[0]=1;
        Map<Integer,Integer> index = new HashMap<Integer,Integer>();
        index.put(arr[0],0);

        for(int i=1;i<dp.length;i++){
            index.put(arr[i],i);

            for(int j=0;arr[j]<=Math.sqrt(arr[i]);j++){
                if(arr[j]*(long )arr[j]==arr[i]){
                    dp[i]+=dp[j] *(long ) dp[j]%MOD;
                    dp[i]%=MOD;
                }
                else if(arr[i]%arr[j]==0&&index.containsKey(arr[i]/arr[j])){
                    dp[i]+=dp[j]*dp[index.get(arr[i]/arr[j])]*2%MOD;
                }
            }
            ans=(ans+dp[i])%MOD;
        }
        return (int)ans;
     }
}