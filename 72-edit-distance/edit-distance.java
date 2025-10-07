class Solution {
    public int minDistance(String s, String t) {
        Integer dp[][] = new Integer[s.length()][t.length()] ;
        return edit(s,t,0,0,dp) ;
    }
    public int edit(String s , String t , int i , int j,Integer dp[][]){
        if(i==s.length()){
            return t.length()-j ;
        }
        if(j==t.length()){
            return s.length()-i ;
        }
        if(dp[i][j]!=null){
            return dp[i][j] ;
        }
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j] =  edit(s,t,i+1,j+1,dp) ;
        }
        int in = 1 + edit(s,t,i,j+1,dp) ;
        int de = 1 + edit(s,t,i+1,j,dp) ;
        int re = 1 + edit(s,t,i+1,j+1,dp) ;
        return dp[i][j] = Math.min(in,Math.min(de,re)) ;
    }
}