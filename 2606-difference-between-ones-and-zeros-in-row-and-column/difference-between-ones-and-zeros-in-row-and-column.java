class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length , n = grid[0].length ;
        int[] oner = new int[m] ;
        int[] onec = new int[n] ;
        for(int i = 0 ;  i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j]==1){
                    oner[i]++ ;
                    onec[j]++ ;
                }
            }
        }
        int[][] diff = new int[m][n] ;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                diff[i][j] = oner[i] + onec[j] - (n-oner[i]) - (m-onec[j]) ;
            }
        }
        return diff ;
    }
}