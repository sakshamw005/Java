class Solution {
    public int findMinimumOperations(String x, String y, String z) {
        if (x.equals(y) && y.equals(z))
            return 0 ;
        int i = 0 ;
        while(i<x.length() && i<y.length() && i<z.length()){
            if(x.charAt(i)==y.charAt(i) && y.charAt(i)==z.charAt(i)){
                i++ ;
            }
            else break ;
        }
        return i==0 ? -1 : (x.length() - i) + (y.length() - i) + (z.length() - i);
    }
}