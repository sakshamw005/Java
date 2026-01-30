class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length+1] ;
        dp[0] = true ;
        for(int i = 2 ; i<=nums.length ; i++){
            if(nums[i-1]==nums[i-2]&& dp[i-2])dp[i] = true ; //two
            if(i>=3 && nums[i-1]==nums[i-2] && nums[i-2]==nums[i-3] &&dp[i-3] )dp[i] = true ;
            if(i>=3 && nums[i-1]-1==nums[i-2] && nums[i-2]-1==nums[i-3] &&dp[i-3])dp[i] = true ;
        }
        return dp[dp.length-1];
    }
}