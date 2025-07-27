class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length ;
        int ans = 0 , j = 0 ;
        for(int i = 1 ; i<=n-2 ; i++){
            if((nums[i]<nums[j]) && (nums[i]<nums[i+1]) 
            || (nums[i]>nums[j]) && (nums[i]>nums[i+1])){
                ans++ ;
                j = i ;
            }
        }
        return ans ;
    }
}