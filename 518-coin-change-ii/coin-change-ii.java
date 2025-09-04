class Solution {
    public int change(int amount, int[] coins) {
        return Coin_ChangeBU(coins,amount) ;
    }
    public static int Coin_ChangeBU(int[] coin , int amount){
        int[][] dp = new int[coin.length+1][amount+1] ;
        for(int i = 0; i < dp.length; i++){ //row
            dp[i][0] = 1 ;
        }
        for(int i = 1 ; i<dp.length ; i++){ //coin
            for(int am = 1 ; am<dp[i].length ; am++){
                int inc = 0 , exc;
                if(am>=coin[i-1]){
                    inc = dp[i][am-coin[i-1]]  ;
                }
                exc = dp[i-1][am];
                dp[i][am] = inc + exc ;
            }
        }
        return dp[dp.length-1][dp[0].length-1] ;
    }
}