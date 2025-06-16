class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1 ;
        int y = nums[0] ;
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i]>y)ans=Math.max(nums[i]-y,ans) ;
            else{y=nums[i];}
        }
        return ans ;
    }
}