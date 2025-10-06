class Solution {
    public int longestCommonSubsequence(String s, String t) {
        // int[][] dp = new int[s.length()][t.length()] ;
        Integer dp[][] = new Integer[s.length()][t.length()] ; //by default null
        return LCS(s,t,0,0,dp) ;
    }
    public int LCS (String s, String t , int ss , int st , Integer dp[][]){
        if(ss>=s.length() || st>=t.length()){
            return 0 ;
        }
        if(dp[ss][st]!=null){
            return dp[ss][st] ;
        }
        if(s.charAt(ss)==t.charAt(st)){
            return dp[ss][st] = 1 + LCS(s,t,ss+1,st+1,dp) ;
        }
        else{
            return dp[ss][st] = Math.max(LCS(s,t,ss+1,st,dp),LCS(s,t,ss,st+1,dp)) ;
        }
    }
}