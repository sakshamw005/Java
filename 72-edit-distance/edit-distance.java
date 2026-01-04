class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][] = new Integer[word1.length()][word2.length()] ;
        return find(word1,word2,word1.length()-1,word2.length()-1,dp) ;
    }
    public int find(String s, String t,int i , int j ,Integer dp[][]){
        if(j<0)return i+1 ;
        if(i<0)return j+1 ;

        if (dp[i][j] != null) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){ //equal
            dp[i][j] = find(s,t,i-1,j-1,dp) ;
        }//adding
        else{
            int add = find(s,t,i,j-1,dp) ; //i pointer remains at same pos , j moves 
            int del = find(s,t,i-1,j,dp) ; //
            int rep = find(s,t,i-1,j-1,dp) ;
            dp[i][j] = 1 + Math.min(add,Math.min(del,rep)) ;
        }
        return dp[i][j] ;
    }
}