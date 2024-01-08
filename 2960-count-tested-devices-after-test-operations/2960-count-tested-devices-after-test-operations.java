class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int minus = 0;
        int n = batteryPercentages.length;
        int res = 0;
        for(int i=0; i<n; i++){
            if(batteryPercentages[i]-minus > 0){
                minus++;
                res++;
            }
        }
        return res;
    }
}