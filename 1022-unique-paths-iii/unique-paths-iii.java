class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroes = 0 , r = 0 , c = 0 ;
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j]==0)zeroes++ ;
                else if(grid[i][j]==1){
                    r = i ;
                    c = j ;
                }
            }
        }
        return print(grid,r,c,zeroes) ;
    }
    public int print(int[][] grid , int r , int c , int x){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==-1){
            return 0 ;
        }
        if(grid[r][c]==2)return x==-1?1:0 ;
        grid[r][c] = -1 ;
        x-- ;
        int tot = print(grid,r+1,c,x) + print(grid,r-1,c,x) + 
                  print(grid,r,c+1,x) + print(grid,r,c-1,x) ;
        grid[r][c] = 0 ;
        x++ ;
        return tot ;
    }
}