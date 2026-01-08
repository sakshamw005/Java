class Solution {
    public Integer[][] dp ;
    public int minZeroArray(int[] nums, int[][] queries) {
        int ans = Integer.MIN_VALUE ;
        for(int i = 0 ; i<nums.length ; i++){
            dp = new Integer[1002][queries.length+1] ;
            int x = solve(nums[i],queries,i,0) ;
            ans = Math.max(ans,x) ;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
    public int solve(int ele , int[][] queries , int elei , int ans){
        if(ele==0)return ans ;
        if(ans>=queries.length)return Integer.MAX_VALUE ;
        int tk = Integer.MAX_VALUE ;
        int nt = Integer.MAX_VALUE ;
        if(dp[ele][ans]!=null)return dp[ele][ans];
        if(queries[ans][0]<=elei && queries[ans][1]>=elei && queries[ans][2]<=ele){
            tk = solve(ele-queries[ans][2],queries,elei,ans+1) ;
        }
        nt = solve(ele,queries,elei,ans+1) ;
        return dp[ele][ans] = Math.min(tk,nt) ;
    }
}