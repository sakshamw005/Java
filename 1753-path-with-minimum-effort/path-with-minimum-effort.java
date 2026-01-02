class Solution {
    public int minimumEffortPath(int[][] heights) {
        int l = 0 , r = 1_000_000 , ans = 0 ;
        while(l<=r){
            int mid = l + (r-l)/2 ;
            if(check(mid,heights)){
                ans = mid ;
                r = mid-1 ;
            }
            else{
                l = mid+1 ;
            }
        }
        return ans;
    }
    public boolean check(int mid , int[][] heights){
        Queue<int[]> q = new LinkedList<>() ;
        boolean[][] seen = new boolean[heights.length][heights[0].length] ;
        q.add(new int[]{0,0}) ;
        seen[0][0] = true ;
        int[] dr = {1,-1,0,0} , dc = {0,0,1,-1} ; 
        while(!q.isEmpty()){
            //remove
            int[] a = q.poll() ;
            int r = a[0] , c = a[1] ;
            //ignore
            if(a[0]==heights.length-1 && a[1]==heights[0].length-1)return true ;
            //mark visited
            //self work
            for(int i = 0 ; i<4 ; i++){
                int nextr = r + dr[i] , nextc = c + dc[i] ;
                if(nextr>=0 && nextr<=heights.length-1 && nextc>=0 && nextc<=heights[0].length-1 && 
                !seen[nextr][nextc] && Math.abs(heights[r][c]-heights[nextr][nextc])<=mid){
                    q.add(new int[]{nextr,nextc}) ;
                    seen[nextr][nextc] = true ;
                }
            }
        }
        return false ;
    }
}