class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)return image ;
        solve(image,sr,sc,color,image[sr][sc]) ;
        return image ;
    }
    public void solve(int[][] image, int sr, int sc, int color , int ori){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=ori)return;
        image[sr][sc] = color ;
        solve(image,sr+1,sc,color,ori) ;
        solve(image,sr-1,sc,color,ori) ;
        solve(image,sr,sc+1,color,ori) ;
        solve(image,sr,sc-1,color,ori) ;
    }
}