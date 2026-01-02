class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;
        return print(n,dp) ;
    }
    public int print(int n,int[] dp){
        if(n<=3)return n ;
        if(dp[n]!=-1)return dp[n] ;
        return dp[n] = print(n-2,dp)+print(n-1,dp) ;
    }
}