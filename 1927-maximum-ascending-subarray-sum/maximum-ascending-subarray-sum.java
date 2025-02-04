class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i] > nums[i - 1]) {
                sum += nums[i];
            } 
            else {
                sum = nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans ;
    }
}