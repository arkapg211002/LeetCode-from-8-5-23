class Solution {
    public int gcd(int a, int b) {
        while(b % a != 0) {
            int val = a;
            a = b % a;
            b = val;
        }
        return a;
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            
            while(st.size() > 0 && gcd(st.peek(), nums[i]) > 1) {
                int val = st.pop();
                nums[i] = (val / gcd(val, nums[i])) * nums[i];
            } 
            st.push(nums[i]);
            
        }
        List<Integer> ans = new ArrayList<>();
        while(st.size() > 0) {
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}