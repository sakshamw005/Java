class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n] ;
        int x = n ;
        if(n%2!=0){
            ans[0] = 0 ;
            for(int i = 1 ; i<n ; i+=2){
                ans[i] = x ;
                ans[i+1] = -x ;
                x++ ;
            }
        }
        else{
            for(int i = 0 ; i<n ; i+=2){
                ans[i] = x ;
                ans[i+1] = -x ;
                x++ ;
            }
        }
        return ans ;
    }
}