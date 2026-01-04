class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder t = new StringBuilder(s.toString()).reverse() ;
        Integer dp[][] = new Integer[s.length()+1][s.length()+1] ;
        return LCS(s,t.toString(),0,0,dp) ;
    }
    public int LCS(String s , String t , int i , int j , Integer dp[][]){
        if(i == s.length() || j == t.length()) return 0;
        if(dp[i][j]!=null){
            return dp[i][j] ;
        }
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j] = 1 + LCS(s,t,i+1,j+1,dp) ;
        }
        else{
            dp[i][j] = Math.max(LCS(s,t,i+1,j,dp),LCS(s,t,i,j+1,dp)) ;
        }
        return dp[i][j] ;
    }
}