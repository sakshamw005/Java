class Solution {
    static int ans = 0 ;
    public int uniquePaths(int m, int n) {
        int[][] mat = new int[m][n] ;
        int[][] dp = new int[m][n] ;
        for(int[] i : dp) Arrays.fill(i,-1) ;
        return print(mat,0,0,dp) ;
    }
    public int print(int[][] mat , int r , int c , int[][] dp){
        if(r==mat.length-1 && c==mat[0].length-1){
            return 1 ;
        }
        if(r>=mat.length || c>=mat[0].length)return 0 ;
        if(dp[r][c]!=-1)return dp[r][c] ;
        int row = print(mat,r+1,c,dp) ;
        int col = print(mat,r,c+1,dp) ;
        return dp[r][c] = row+col ;
    }
}