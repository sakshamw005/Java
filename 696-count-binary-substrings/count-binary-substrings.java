class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0 , res = 1 , man = 0 ;
        for(int i = 1 ; i<s.length() ; i++){
            if(s.charAt(i-1)==s.charAt(i))res++ ;
            else{
                ans = res ;
                res = 1 ;
            }
            if(res<=ans)man++ ;
        }
        return man ;
    }
}
