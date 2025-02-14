class Solution {
    public void solveSudoku(char[][] board) {
        print(board,0,0) ;
        printBoard(board);
    }
    public static boolean print(char[][] board , int row , int col){
        if(col==9){
            row++ ;
            col = 0 ;
        }
        if(row==9){
            return true ;
        }
        if (board[row][col] != '.') {
            return print(board, row, col + 1);
        } else {
            for (char val = '1' ; val <= '9' ; val++) {
                if (isItSafe(board, row, col, val)) {
                    board[row][col] = val;
                    if (print(board, row, col + 1)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static boolean isItSafe(char[][] grid, int row, int col,char val) {
        // Check row
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == val) {
                return false;
            }
        }
        // Check column
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == val) {
                return false;
            }
        }
        // Check 3x3 sub-grid
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (grid[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}