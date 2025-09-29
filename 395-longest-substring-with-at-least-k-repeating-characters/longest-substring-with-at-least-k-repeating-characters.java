class Solution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26] ;
        for(int i = 0 ; i<s.length() ;i++){
            freq[s.charAt(i) - 'a']++ ;
        }
        for(int i = 0 ; i<s.length() ; i++){
            if(freq[s.charAt(i) - 'a']<k){
                int l = longestSubstring(s.substring(0,i),k) ;
                int r = longestSubstring(s.substring(i+1,s.length()),k) ;
                return Math.max(l,r) ;
            }
        }
        return s.length() ;
    }
}