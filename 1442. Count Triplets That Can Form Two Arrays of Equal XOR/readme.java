// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/?envType=daily-question&envId=2024-05-30

class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            int temp = 0;
            for(int j=i;j<n;j++){
                temp = temp ^ arr[j];
                if(temp == 0){
                    count += j-i;
                }
            }
        }
        return count;
    }
}
