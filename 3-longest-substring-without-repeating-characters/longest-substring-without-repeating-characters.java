class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 , max = 0 ; 
        HashSet<Character> h = new HashSet<>() ;
        for(int ri = 0 ; ri < s.length() ; ri++){
            while(h.contains(s.charAt(ri))){
                h.remove(s.charAt(left++)) ;
            }
            h.add(s.charAt(ri)) ;
            max = Math.max(max , ri-left + 1) ;
        }
        return max ;
    }
}