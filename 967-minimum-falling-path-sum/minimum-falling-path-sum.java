class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] d : dp){
            Arrays.fill(d,-666666);
        }
        for(int col = 0 ; col<matrix[0].length ; col++){
            ans = Math.min(ans,Minimum_Falling_Path(matrix,0,col,dp)) ;
        }
        return (ans);
    }
    public int Minimum_Falling_Path(int[][] matrix,int cr,int cc,int[][] dp){
        if(cc<0 || cc>=matrix[0].length){
            return Integer.MAX_VALUE;
        }
        if(cr==matrix[0].length-1){
            return matrix[cr][cc];
        }
        if(dp[cr][cc]!=-666666){
            return dp[cr][cc];
        }
        int ld = Minimum_Falling_Path(matrix,cr+1,cc-1,dp);
        int rd = Minimum_Falling_Path(matrix,cr+1,cc+1,dp);
        int d = Minimum_Falling_Path(matrix,cr+1,cc,dp);
        return dp[cr][cc] = Math.min(rd,Math.min(ld,d)) + matrix[cr][cc];
    }
}