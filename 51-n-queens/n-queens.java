class Solution {
    public List<String> makeit(int[][] mat){
        List<String> ans = new ArrayList<>() ;
        for(int i = 0 ; i<mat.length ; i++){
            StringBuilder sb = new StringBuilder() ;
            for(int j = 0 ; j<mat[0].length ; j++){
                sb.append(mat[i][j] == 1 ? 'Q' : '.') ;
            }
            ans.add(sb.toString()) ;
        }
        return ans ;
    }
    public List<List<String>> solveNQueens(int n) {
        int[][] mat = new int[n][n] ;
        List<List<String>> ans = new ArrayList<>() ;
        queen(n,0,mat,ans) ;
        return ans ;
    }
    public void queen(int n , int row , int[][] mat , List<List<String>> ans){
        if(row==n){
            ans.add(makeit(mat)) ;
            return ;
        }
        for(int col = 0 ; col<n ; col++){
            if(isSafe(n,row,col,mat)){
                mat[row][col] = 1 ;
                queen(n,row+1,mat,ans) ;
                mat[row][col] = 0 ;
            }
        }
    }
    public boolean isSafe(int n ,int row , int col , int[][] mat){
        //row
        for(int i = 0 ; i<n ; i++){
            if(mat[row][i]==1){
                return false ;
            }
        }
        //col
        for(int i = 0 ; i<n ; i++){
            if(mat[i][col]==1){
                return false ;
            }
        }
        //left diagonal top 
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
            if(mat[i][j] == 1) return false;
        }
        //right diagonal top
        for(int i = row-1, j = col+1; i>=0 && j<n; i--, j++) {
            if(mat[i][j] == 1) return false;
        }
        return true ;
    }
}