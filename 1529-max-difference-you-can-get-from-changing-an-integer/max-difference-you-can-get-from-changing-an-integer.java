class Solution {
    public int maxDiff(int num) {
        return print(num) ;
    }
    public static int print(int num){
        StringBuilder n = new StringBuilder(String.valueOf(num));
        StringBuilder m = new StringBuilder(n);
        char max = ' ' ;
        for(int i = 0 ; i<n.length() ; i++){
            if(n.charAt(i)!='9'){
                max = n.charAt(i) ;
                break ;
            }
        } 
        if(max!=' '){
            for(int i = 0; i < n.length(); i++) {
                if(n.charAt(i) == max) {
                    n.setCharAt(i, '9');
                }
            }
        }
        char kisko = ' ' , kisse = ' ' ;
        if(m.charAt(0)!='1'){
            kisko = m.charAt(0) ;
            kisse = '1' ;
        } 
        else{
            for(int i = 1 ; i<m.length() ; i++){
                if(m.charAt(i)!='0' && m.charAt(i)!='1'){
                    kisko = m.charAt(i) ;
                    kisse = '0' ;
                    break ;
                }
            }
        }
        if(kisko!=' '){
            for(int i = 0 ; i<m.length() ; i++){
                if(m.charAt(i)==kisko){
                    m.setCharAt(i,kisse) ;
                }
            }
        }
        return (Integer.valueOf(n.toString()) - Integer.valueOf(m.toString())) ;
    }
}