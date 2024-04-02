class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for(int ele:nums){
            sum+=encrtypte(ele);
        }
        return sum;
    }
    public int encrtypte(int n){
        int result=0;
        int largestele=0;
        int numberofele=0;
        while(n!=0){
            int rem=n%10;
            if(rem>largestele){
                largestele=rem;
            }
            
            numberofele++;
            n=n/10;
        }
        while(numberofele!=0){
            result=result*10+largestele;
            numberofele--;
        }
        return result;
        
    }
}