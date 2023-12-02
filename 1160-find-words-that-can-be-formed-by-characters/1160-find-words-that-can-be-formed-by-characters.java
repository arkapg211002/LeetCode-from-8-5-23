class Solution {
    public boolean check(String word, Map<Character, Integer> chars){
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<word.length();i++){
            char curr = word.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr, 0);
            }
            map.replace(curr, map.get(curr)+1);
            
            if(!chars.containsKey(curr) || chars.get(curr)<map.get(curr)){
                return false;
            }
        }
        
        return true;
    }
    
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            char curr = chars.charAt(i);
            if(!map.containsKey(curr)){
                map.put(curr, 0);
            }
            map.replace(curr, map.get(curr)+1);
        }
        
        int count = 0;
        for(int i=0;i<words.length;i++){
            if(check(words[i], map)){
                count += words[i].length();
            }
        }
        
        return count;
    }
}