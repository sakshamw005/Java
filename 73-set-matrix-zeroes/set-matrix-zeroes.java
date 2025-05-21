class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length ; 
        int c = matrix[0].length ;
        boolean[] ro = new boolean[r] ;
        boolean[] co = new boolean[c] ;
        for(int i = 0 ; i<r ; i++){
            for(int j = 0 ; j<c ; j++){
                if(matrix[i][j]==0){
                    ro[i] = true ;
                    co[j] = true ;
                }
            }
        }
        for(int i = 0 ; i<r ; i++){
            for(int j = 0 ; j<c ; j++){
                if(ro[i] || co[j]){
                    matrix[i][j] = 0 ;
                }
            }
        }
    }
}