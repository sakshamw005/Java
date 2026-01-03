class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i : nums)sum+=i ;
        if(sum%2==1)return false ;
        int t = sum/2 ;
        int[][] dp = new int[nums.length][t+1] ;
        for(int[] i : dp)Arrays.fill(i,-1) ;
        return check(nums,dp,nums.length-1,t) ;
    }
    public boolean check(int[] nums , int[][] dp , int i,int t){
        if(t==0)return true ;
        if(i<0 || t<0)return false ;
        if (dp[i][t] != -1){
            return dp[i][t] == 1;
        }
        boolean take = false ;
        if(nums[i]<=t){
            take = check(nums,dp,i-1,t-nums[i]) ;
        }
        boolean ntake = check(nums,dp,i-1,t) ;
        dp[i][t] = take || ntake ? 1 : 0 ;
        return dp[i][t]==1 ;
    }
}