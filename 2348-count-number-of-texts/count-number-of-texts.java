class Solution {
    private int MOD = 1_000_000_007 ; 
    public int countTexts(String p) {
        long[] dp = new long[p.length()+1] ;
        dp[0] = 1 ;

        for(int i = 1 ; i<=p.length() ; i++){
            char x = p.charAt(i-1) ;
            int max = (x=='7' || x=='9') ? 4 : 3 ;
            for(int j = 1 ; j<=max && i-j>=0 ; j++){
                if(p.charAt(i-j)!=x)break ;
                dp[i] = (dp[i]+dp[i-j])%MOD ;
            }
        }
        return (int)dp[p.length()] ;
    }
}