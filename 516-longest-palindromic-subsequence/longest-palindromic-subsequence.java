class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString() ;
        int dp[][] = new int[s.length()][s.length()] ;
        for(int i[] : dp){
            Arrays.fill(i,-1) ;
        }
        return LCS(s,rev,0,0,dp) ;
    }
    public int LCS(String s , String t , int i , int j,int dp[][]){
        if(i>=s.length() || j>=t.length()){
            return 0 ;
        }
        if(dp[i][j]!=-1){
            return dp[i][j] ;
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] = 1 + LCS(s,t,i+1,j+1,dp) ;
        }
        else{
            return dp[i][j] = Math.max(LCS(s,t,i+1,j,dp),LCS(s,t,i,j+1,dp)) ;
        }
    }
}