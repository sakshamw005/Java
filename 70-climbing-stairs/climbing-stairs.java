class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1] ;
        return compute(dp,n) ;
    }
    public int compute(int[] dp , int n){
        if(n==1)return 1 ;
        if(n==2)return 2 ;
        if(dp[n]!=0){
            return dp[n] ;
        }
        return dp[n] = compute(dp,n-1) + compute(dp,n-2) ;
    }
}