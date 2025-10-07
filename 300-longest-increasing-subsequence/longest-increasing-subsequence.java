class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length+1][nums.length] ;
        return print(nums,-1,0,dp) ;
    }
    public int print(int[] nums , int prev , int curr , Integer dp[][]){
        if(curr>=nums.length){
            return 0 ;
        }
        if (dp[prev + 1][curr] != null) {
            return dp[prev + 1][curr];
        }
        int ex = print(nums,prev,curr+1,dp) ;
        int inc = 0 ;
        if(prev==(-1) || nums[curr]>nums[prev]){
            inc = 1 + print(nums,curr,curr+1,dp);
        }
        return dp[prev+1][curr] = Math.max(inc,ex) ;
    }
}