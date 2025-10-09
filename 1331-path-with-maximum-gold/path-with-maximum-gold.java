class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length , n = grid[0].length ;
        int ans = 0 ;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j]!=0){
                    ans = Math.max(ans,make(grid,i,j)) ;
                }
            }
        }
        return ans ;
    }
    public int make(int[][] grid , int row , int col){
        if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1 || grid[row][col]==0){
            return 0 ;
        }
        int m = grid[row][col] ;
        int curr = m ;

        grid[row][col] = 0 ;

        int down = make(grid,row+1,col) ; 
        int up = make(grid,row-1,col) ;
        int right = make(grid,row,col+1) ;
        int left = make(grid,row,col-1) ;
        grid[row][col] = m ;

        return m + Math.max(Math.max(up,down) , Math.max(left,right)) ; 
    }
}