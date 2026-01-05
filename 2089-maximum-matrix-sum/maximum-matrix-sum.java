class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int c = 0 ;
        long tot = 0L ;
        int min = Integer.MAX_VALUE ;
        for(int i = 0 ; i<matrix.length ; i++){
            for(int j = 0 ;j<matrix[0].length ; j++){
                if(matrix[i][j]<0)c++ ;
                tot+=Math.abs(matrix[i][j]) ;
                min = Math.min(min,Math.abs(matrix[i][j])) ;
            }
        }
        if(c%2==0){
            return tot ;
        }
        else{
            // System.out.println(min) ;
            return tot - 2*min ;
        }

    }
}