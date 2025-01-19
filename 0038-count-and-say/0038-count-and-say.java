class Solution {
    public String countAndSay(int n) {
        return print(n) ;
    }
    public static String RLE(String s){
        StringBuilder ans = new StringBuilder() ;
        int count = 1 ;
        for(int i = 0 ; i<s.length()-1 ; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++ ;
            }
            else{
                ans.append(count) ;
                ans.append(s.charAt(i)) ;
                count = 1 ;
            }
        }
        ans.append(count) ;
        ans.append(s.charAt(s.length()-1)) ;
        return ans.toString() ;
    }
    public static String print(int n){
        if(n==1){
            return "1" ;
        }
        return RLE(print(n-1)) ;
    }
}