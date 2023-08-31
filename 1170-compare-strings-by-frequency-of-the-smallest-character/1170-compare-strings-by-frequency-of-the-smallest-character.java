
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        int j =0;
        for(String query : queries){
            int val = 0;
            for(String word : words){
                if(frequency(query) < frequency(word)){
                    val++;
                }
            }
            res[j] = val;
            j++;
        }
        return Arrays.stream(res).toArray();
    }
    public int frequency(String word){
        List<Character> list = new ArrayList<>();
        int count = 0;
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i<arr.length;i++){
            if(arr[0] == arr[i]){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}