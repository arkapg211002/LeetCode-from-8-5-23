// https://leetcode.com/problems/replace-words/description/?envType=daily-question&envId=2024-06-07

import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        dictionary.stream().forEach(trie::addWord);
        String[] words = sentence.split("\\s+");
        for(int i = 0; i < words.length; ++i) 
            words[i] = trie.getRoot(words[i]);
        return String.join(" ", words);
    }

    class Node 
    {
        public boolean isWord = false;
        public Node[] children;
        public Node() 
        {
            this.children = new Node[26];
        }
    }

    class Trie 
    {
        Node root;
        public Trie() 
        {
            this.root = new Node();
        }
        public void addWord(String word) 
        {
            Node current = root;
            for(int i = 0; i < word.length(); ++i) 
            {
                int index = word.charAt(i) - 'a';
                if(current.children[index] == null)
                    current.children[index] = new Node();
                current = current.children[index];
            }
            current.isWord = true;
        }
        public String getRoot(String word) 
        {
            Node current = root;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < word.length() && current != null; ++i) 
            {
                int index = word.charAt(i) - 'a';
                current = current.children[index];
                if(current != null) 
                {
                    sb.append(word.charAt(i));
                    if(current.isWord) return sb.toString();
                }
            }
            return word;
        }
    }
}
