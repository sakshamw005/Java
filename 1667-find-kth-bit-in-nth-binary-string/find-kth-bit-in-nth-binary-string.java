class Solution {
    public char findKthBit(int n, int k) {
        String a = kb(n) ;
        return a.charAt(k-1) ;
    }
    public static String kb(int n){
        if(n==1){
            return "0" ;
        }
        return kb(n-1) + "1" + bits(kb(n-1)) ;
    }
    public static String bits(String s){
        StringBuilder ans = new StringBuilder() ;
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i)=='0'){
                ans.append('1') ;
            }
            else{
                ans.append('0') ;
            }
        }
        return ans.reverse().toString() ;
    }
}