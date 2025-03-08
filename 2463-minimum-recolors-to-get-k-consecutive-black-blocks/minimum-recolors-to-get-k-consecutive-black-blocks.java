class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wc = 0 ;
        for(int i = 0 ; i<k ; i++){
            if(blocks.charAt(i)=='W'){
                wc++ ;
            }
        }
        int ans = wc ;
        for(int i = k ; i<blocks.length() ; i++){
            if(blocks.charAt(i-k)=='W'){
                wc-- ;
            }
            if (blocks.charAt(i) == 'W') {
                wc++ ;
            }
            ans = Math.min(ans,wc) ;
        }
        return ans ;
    }
}