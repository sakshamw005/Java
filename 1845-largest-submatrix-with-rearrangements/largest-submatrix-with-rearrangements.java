class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        int[][] col = new int[matrix.length][matrix[0].length] ;
        for(int j = 0 ; j < n ; j++) col[0][j] = matrix[0][j];
        for(int i = 1 ; i<matrix.length ; i++){
           for(int j = 0 ; j<matrix[0].length ; j++){
                if(matrix[i][j] == 1) col[i][j] = col[i-1][j] + 1;
                else col[i][j] = 0;
            }
        }
        // for(int i = 0 ; i<matrix.length ; i++){
        // for(int j = 0 ; j<matrix[0].length ; j++){
        //     System.out.print(col[i][j]+" ") ;
        // }
        // System.out.println() ;
        // } 
        int ans = -1 ;
        for(int i = 0 ; i<m ; i++){
            int[] curr = col[i] ;
            Arrays.sort(curr) ;
            for(int j = 0 ; j<curr.length ; j++){
                ans = Math.max(ans , curr[j]*(curr.length-j)) ;
            }
        }
        return ans ;
    }
}