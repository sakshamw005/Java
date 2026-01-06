class Solution {
    public int tribonacci(int n) {
        long[] dp = new long[n+1] ;
        Arrays.fill(dp,-1) ;
        return (int)tribo(n,dp) ;
    }
    public long tribo(int n,long[] dp){
        if(n==0) return dp[n] = 0 ;
        if(n==1 || n==2)return dp[n] = 1 ;
        if(dp[n]!=-1)return dp[n] ;
        return dp[n] = tribo(n-2,dp) + tribo(n-1,dp) + tribo(n-3,dp) ; 
    }
}