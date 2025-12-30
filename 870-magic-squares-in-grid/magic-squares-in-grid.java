class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length<3)return 0 ;
        int r = grid.length , c = grid[0].length , ans = 0 ;
        for(int i = 0 ; i+2<r ; i++){
            for(int j = 0 ; j+2<c ; j++){
                if(unique(grid,i,j) && centre(grid,i,j) && check(grid,i,j)) ans++ ;
            }
        }
        return ans ;
    }
    public boolean check(int[][] grid, int row, int col) {
        int ref = 0;
        for (int j = col; j < col + 3; j++) {
            ref += grid[row][j];
        }

        // check rows
        for (int i = row; i < row + 3; i++) {
            int s = 0;
            for (int j = col; j < col + 3; j++) {
                s += grid[i][j];
            }
            if (s != ref) return false;
        }

        // check columns
        for (int j = col; j < col + 3; j++) {
            int s = 0;
            for (int i = row; i < row + 3; i++) {
                s += grid[i][j];
            }
            if (s != ref) return false;
        }

        // main diagonal
        int d1 = 0;
        for (int i = 0; i < 3; i++) {
            d1 += grid[row + i][col + i];
        }
        if (d1 != ref) return false;

        // secondary diagonal
        int d2 = 0;
        for (int i = 0; i < 3; i++) {
            d2 += grid[row + i][col + 2 - i];
        }
        if (d2 != ref) return false;

        return true;
    }

     public boolean unique(int[][] grid, int row, int col) {
        boolean[] seen = new boolean[10];

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }
        return true;
    }
    public boolean centre(int[][] grid , int row , int col){
        return grid[row+1][col+1] == 5 ;
    }
}