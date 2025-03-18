class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1 ;
        int left = 0 , curr = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            while ((curr & nums[i]) != 0) {
                curr ^= nums[left];
                left++;
            }
            curr |= nums[i];
            ans = Math.max(ans, i - left + 1);
        }
        
        return ans ;
    }
}