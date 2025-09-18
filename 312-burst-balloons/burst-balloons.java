class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length ;
        int[][] dp = new int[n+2][n+2] ;
        for(int[] i : dp){
            Arrays.fill(i,-1) ;
        }
        int[] a = new int[arr.length+2] ;
        a[0] = a[a.length-1] = 1 ;
        System.arraycopy(arr, 0, a, 1, arr.length);
        return (Burst_Coin(a,0,a.length-1,dp)) ;
    }
    public static int Burst_Coin(int[] a , int i , int j,int[][] dp ){
        if(i+1==j)return 0 ;
        if(dp[i][j]!=-1){
            return dp[i][j] ;
        }
        int ans = Integer.MIN_VALUE ;
        for(int k = i+1 ; k<j ; k++){
            int l = Burst_Coin(a,i,k,dp) ;
            int r = Burst_Coin(a,k,j,dp) ;
            int self = a[i] * a[j] * a[k] ;
            ans = Math.max(ans,l+r+self) ;
        }
        return dp[i][j] = ans;
    }
}