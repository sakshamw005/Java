class Solution {
    public int numOfSubarrays(int[] arr) {
        int ans = 0 , sum = 0 , oddcount = 0 , evencount = 1 ;
        final int MOD = 1_000_000_007;
        for(int i = 0 ; i<arr.length ; i++){
            sum += arr[i] ;
            if(sum%2!=0){
                ans = (ans + evencount)%MOD ;
                oddcount++ ;
            }
            else{
                ans = (ans + oddcount)%MOD ;
                evencount++ ; 
            }
        }
        return ans ;
    }
}