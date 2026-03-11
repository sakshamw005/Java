class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n) ;
        StringBuilder x = new StringBuilder() ;
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i)=='0')x.append('1') ;
            else x.append('0') ;
        }
        return Integer.parseInt(x.toString(),2) ;
    }
}