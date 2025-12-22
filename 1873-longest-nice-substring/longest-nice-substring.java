class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "" ;
        for(int i = 0 ; i<s.length() ; i++){
            for(int j = i+1 ; j<=s.length() ; j++){
                if(check(s.substring(i,j)) && ans.length()<(j-i)){
                    ans = s.substring(i,j) ;
                }
            }
        }
        return ans ;
    }
    public boolean check(String s){
        for(int i = 0 ; i<s.length() ; i++){
            char x = s.charAt(i) ;
            if(!s.contains(Character.toUpperCase(x)+"") || !s.contains(Character.toLowerCase(x)+"")){
                return false ;
            }
        }
        return true ;
    }
}