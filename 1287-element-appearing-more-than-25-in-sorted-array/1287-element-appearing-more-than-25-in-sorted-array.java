class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int target = arr.length / 4;
        
        for(int i = 0, count = 1; i < arr.length - 1; i++){
            if(arr[i] == arr[i+1]){
                count++;
                if(count > target)
                    return arr[i];
            }else
                count = 1;
        }
        return arr[0];
    }
}