class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][] = new Integer[word1.length()][word2.length()] ;
        return find(word1,word2,word1.length()-1,word2.length()-1,dp) ;
    }
    public int find(String s, String t,int i , int j ,Integer dp[][]){
        if(j<0)return i+1 ;
        if(i<0)return j+1 ;
        if (dp[i][j] != null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j))dp[i][j] = find(s,t,i-1,j-1,dp) ; //adding
        else dp[i][j] = 1 + Math.min(find(s,t,i,j-1,dp),Math.min(find(s,t,i-1,j,dp),find(s,t,i-1,j-1,dp) )) ;
        return dp[i][j] ;
    }
}