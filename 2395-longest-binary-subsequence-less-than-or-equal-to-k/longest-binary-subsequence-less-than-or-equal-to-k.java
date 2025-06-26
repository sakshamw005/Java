class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0 ;
        long curr = 0 ;
        int pow = 0 ;
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i)=='0'){
                ans++ ;
            }
        }
        for(int i = s.length()-1 ; i>=0 ; i--){
            if(s.charAt(i)=='1'){
                double val = Math.pow(2,pow) ;
                if(curr+val<=k){
                    ans++ ;
                    curr+=val ;
                }
                pow++ ;
            }else{
                pow++ ;
            }
            if(Math.pow(2,pow)>k)break ;
        }
        return ans ;
    }
}