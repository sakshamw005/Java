class Solution {
    public void solveSudoku(char[][] board) {
        solve(board,0,0) ;
    }
    public boolean solve(char[][] board,int row,int col){
        if(col==9){
            row++ ;
            col = 0 ;
        }
        if(row==9){
            return true ;
        }
        if(board[row][col]!='.'){
            return solve(board,row,col+1) ;
        }
        for(char x = '1' ; x<='9' ; x++){
            if(safe(board,row,col,x)){
                board[row][col] = x ;
                if(solve(board,row,col+1)){
                    return true ;
                }
                board[row][col] = '.' ;
            }
        }
        return false ;
    }
    public boolean safe(char board[][] , int row , int col , char ch){
        //row
        for(int i = 0 ; i<board.length ; i++){
            if(board[row][i]==ch){
                return false ;
            }
        }
        //col
        for(int i = 0 ; i<board.length ; i++){
            if(board[i][col]==ch){
                return false ;
            }
        }
        //3x3 sub-matrix
        int r = row - row%3 ;
        int c = col - col%3 ;
        for(int i = r ; i<r+3 ; i++){
            for(int j = c ; j<c+3 ; j++){
                if(board[i][j]==ch){
                    return false ;
                }
            }
        }
        return true ;
    }
}