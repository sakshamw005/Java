class Solution {
    static int i = 0 ;
    public int calculate(String s) {
        i = 0 ;
        return calc(s) ;
    }
    public static int calc(String s){
        int num = 0 , ans = 0 , sign = 1 ;
        while(i<s.length()){
            char ch = s.charAt(i++) ;
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0') ;
            }
            else if(ch == '('){
                num = calc(s) ;
            }
            else if(ch == ')'){
                return ans + num * sign ;
            }
            else if (ch == '+' || ch == '-') {
                ans += num * sign;
                num = 0;
                sign = ch == '-' ? -1 : 1;
            }
        }
        return ans + num * sign;
    }
}