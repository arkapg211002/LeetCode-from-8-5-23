class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = right;
        while(right>left){
            ans = right & (right-1);
            right = ans;
        } 
        return ans;
    }
}
