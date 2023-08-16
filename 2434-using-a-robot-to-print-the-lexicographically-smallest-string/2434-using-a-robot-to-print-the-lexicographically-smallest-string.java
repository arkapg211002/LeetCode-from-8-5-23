class Solution {
    public String robotWithString(String s) {
        char[] arr = s.toCharArray();
        int[] rightMin = new int[arr.length]; // index 
        int n = arr.length;
        rightMin[n - 1] = n - 1;
        
        for (int i = n - 2; i >= 0; i--){
            char curr = arr[i];

            if(curr > arr[rightMin[i + 1]]) {
                rightMin[i] = rightMin[i + 1];
            } else {
                rightMin[i] = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();

        int start = 0;
        StringBuilder left = new StringBuilder();
        while (start < n) {
            int end = rightMin[start];
            if(left.length() != 0 && left.charAt(left.length() - 1) <= arr[end]) {
                sb.append(left.charAt(left.length() - 1));
                left.deleteCharAt(left.length() - 1);
            } else {
                sb.append(arr[end]);
                left.append(s.substring(start, end));
                start = end + 1;
            }
        }
        
        sb.append(left.reverse());
        return sb.toString();
    }
}