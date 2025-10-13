class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>() ;
        ans.add(words[0]) ;
        String prev = keymake(words[0]) ;
        for(int i = 1 ; i<words.length ; i++){
            String keyy = keymake(words[i]) ;
            if(!keyy.equals(prev)){
                ans.add(words[i]) ;
                prev = keyy ;
            }
        }
        return ans ;
    }
    public String keymake(String s){
        int freq[] = new int[26] ;
        for(int i = 0 ; i<s.length() ; i++){
            freq[s.charAt(i) - 'a']++ ;
        }
        StringBuilder ans = new StringBuilder() ;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                ans.append((char)('a' + i)).append(freq[i]);
            }
        }
        return ans.toString() ;
    }
}