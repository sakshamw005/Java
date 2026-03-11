class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie() ;
        for(String i : strs){
            trie.insert(i) ;
        }
        return trie.getLCP(strs[0]) ;
    }
    class TrieNode{
        TrieNode[] child = new TrieNode[26] ;
        boolean isEnd ;
    }
    class Trie{
        TrieNode root ;
        public Trie(){
            root = new TrieNode() ;
        }
        void insert(String w){
            TrieNode curr = root ;
            for(char x : w.toCharArray()){
                if(curr.child[x-'a']==null){
                    curr.child[x-'a'] = new TrieNode() ;
                }
                curr = curr.child[x-'a'] ;
            }
            curr.isEnd = true ;
        }
        String getLCP(String word){
            TrieNode curr = root ;
            StringBuilder ans = new StringBuilder() ;
            for(char x : word.toCharArray()){
                int c = 0 ;
                for(int i = 0 ; i<26 ; i++){
                    if(curr.child[i]!=null)c++ ;
                }
                if(c==1 && !curr.isEnd ){
                    ans.append(x) ;
                    curr = curr.child[x-'a'] ;
                }
                else{
                    break ;
                }
            }
            return ans.toString() ;
        }
    }
}