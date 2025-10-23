class Solution {
    public static boolean hasSameDigits(String s) {
        StringBuilder str = new StringBuilder(s) ;
        while(str.length()>2){
            StringBuilder x = new StringBuilder() ;
            for(int i = 0 ; i<str.length()-1 ; i++){
                int num1 = str.charAt(i) - '0' ;
                int num2 = str.charAt(i+1) - '0' ;
                x.append((num1+num2)%10) ;
            }
            str.delete(0, str.length());
            str = x ;
        }
        return str.charAt(0)==str.charAt(1) ;
    }
}