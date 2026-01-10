class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1.equals(s2))return 0 ;
        Integer[][] dp = new Integer[s1.length()+1][s2.length()+1] ;
        int x = lcs(s1,s2,0,0,dp) ;
        int ans = 0 ;
        for(char y : s1.toCharArray())ans+=(int)y ;
        for(char y : s2.toCharArray())ans+=(int)y ;
        // System.out.println(x) ;
        return ans-2*x ;
    }
    public static int lcs(String s1,String s2,int i,int j,Integer[][] dp){
        if(i>=s1.length() || j>=s2.length()){
            return 0 ;
        }
        if(dp[i][j]!=null)return dp[i][j] ;
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = s1.charAt(i) + lcs(s1,s2,i+1,j+1,dp) ;
        }
        else{
            return dp[i][j] = Math.max(lcs(s1,s2,i+1,j,dp),lcs(s1,s2,i,j+1,dp)) ;
        }
    }
}