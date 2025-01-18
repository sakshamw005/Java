class Solution {
    public int myAtoi(String s) {
        int sign = 1 ;
        int m = 0 ;
        int ans = 0 ;
        String x = s.trim() ;
        if(x.isEmpty()){
            return 0 ;
        }
        if(x.charAt(0)=='-'){
            sign = -1 ; m++ ;
        }
        else if(x.charAt(0)=='+'){
            m++ ;
        }
        while(m<x.length() && Character.isDigit(x.charAt(m))){
            int digit = x.charAt(m) - '0' ;
            if (ans > (Integer.MAX_VALUE-digit)/10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans*10+digit ;
            m++ ;
        }
        
        return ans*sign ;
    }
}