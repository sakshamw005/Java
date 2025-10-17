class Solution {
    public int uniquePathsIII(int[][] grid) {
        int x = 0 , r = 0 , c = 0 ;
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j]==0)x++ ;
                else if(grid[i][j]==1){
                    r = i ; 
                    c = j ;
                }
            }
        } 
        return call(r,c,grid,x) ;
    }
    public int call(int r , int c , int[][] grid,int x){
        if(r>=grid.length || r<0 || c>=grid[0].length || c<0 || grid[r][c]==-1){
            return 0 ;
        }
        if(grid[r][c]==2){
            return x == -1?1:0 ;
        }
        grid[r][c] = -1 ;
        x-- ;

        int tot = call(r+1,c,grid,x) + call(r,c-1,grid,x) + call(r-1,c,grid,x) + call(r,c+1,grid,x) ;
        
        grid[r][c] = 0 ;
        x++ ;

        return tot ;
    }
}