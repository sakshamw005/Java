class Solution {
    public char findTheDifference(String s, String t) {
        if(s.length()==0)return t.charAt(0) ;
        char[] o = s.toCharArray() ;
        char[] tw = t.toCharArray() ;
        Arrays.sort(o) ;
        Arrays.sort(tw) ;
        for(int i = 0 ; i < t.length() ; i++){
            if(i==s.length())return tw[i] ;
            if (o[i] != tw[i]) {
                return tw[i]; 
            }
        }
        return '0' ;
    }
}