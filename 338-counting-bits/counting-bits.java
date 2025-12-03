class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1] ;
        ans[0] = 0 ;
        int var = 1 ;
        for(int i = 1 ; i<=n ; i++){
            if(i==var*2)var = i ;
            ans[i] = 1 + ans[i-var] ;
        }
        return ans ;
    }
}