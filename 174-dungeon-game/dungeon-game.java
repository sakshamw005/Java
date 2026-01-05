class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int l = 1 , r = Integer.MAX_VALUE , ans = 0 ;
        while(l<=r){
            int mid = l + (r-l)/2 ;
            if(isFine(dungeon,mid)){
                r = mid - 1;
                ans = mid ;
            }
            else{
                l = mid + 1 ;
            }
        }
        return ans ;
    }
    public boolean isFine(int[][] arr , int val){
        long[][] dp = new long[arr.length][arr[0].length] ;
        for(long[] x : dp){
            Arrays.fill(x,-1) ;
        }
        int ans = val + arr[0][0] ;
        if(ans<0)return false ;
        dp[0][0] = ans ;
        for(int i = 0 ; i<arr.length ; i++){
            for(int j = 0 ; j<arr[0].length ; j++){
                if (dp[i][j] <= 0) continue;
                // Down
                if (i + 1 < arr.length) {
                    long nh = dp[i][j] + arr[i + 1][j];
                    if (nh > 0){
                        dp[i + 1][j] = Math.max(dp[i + 1][j], nh);
                    }
                }
                //rightt
                if (j + 1 < arr[0].length) {
                    long nh = dp[i][j] + arr[i][j + 1];
                    if (nh > 0)
                        dp[i][j + 1] = Math.max(dp[i][j + 1], nh);
                    }
                }
            }
        return dp[arr.length - 1][arr[0].length - 1] > 0;
    }
}

//         explore(dungeon,0,0,0) ;
//         System.out.println(ans) ;
//         return 0 ;
//     }
//     public void explore(int[][] dungeon,int s,int r , int c){
//         if(r==dungeon.length-1 && c==dungeon[0].length-1){
//             s+=dungeon[r][c] ;
//             if(s<0)ans = Math.min(ans,Math.abs(s)) ;
//             return ;
//         }
//         if(r<0 || r>=dungeon.length || c<0 || c>=dungeon[0].length){
//             return ;
//         }
//         //right
//         s+=dungeon[r][c] ;
//         explore(dungeon,s,r+1,c) ;
//         explore(dungeon,s,r,c+1) ;
//     }
// }