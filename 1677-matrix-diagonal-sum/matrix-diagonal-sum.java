class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length ;
        if(n==1)return mat[0][0] ;
        boolean[][] check = new boolean[n][n] ;
        int ans = 0 ;
        //primary
        for(int i = 0 ; i<n ; i++){
            if(!check[i][i]){
                ans+=mat[i][i] ;
                check[i][i] = true ;
            }
        }
        //secondary
        for(int i = 0 ; i<n ; i++){
            if(!check[i][n-i-1]){
                ans+=mat[i][n-i-1] ;
            }
        }
        return ans ;
    }
}