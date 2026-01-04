class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length , n = obstacleGrid[0].length ;
        int[][] dp = new int[m][n] ;
        for(int[] i : dp) Arrays.fill(i,-1) ;
        return print(obstacleGrid,0,0,dp) ;
    }
    public int print(int[][] mat , int r , int c , int[][] dp){
        if(r>=mat.length || c>=mat[0].length || mat[r][c] == 1)return 0 ;
        if(r==mat.length-1 && c==mat[0].length-1){
            return 1 ;
        }
        if(dp[r][c]!=-1)return dp[r][c] ;
        int row = print(mat,r+1,c,dp) ;
        int col = print(mat,r,c+1,dp) ;
        return dp[r][c] = row+col ;
    }
}