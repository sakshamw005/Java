class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length , ans = 0 ;
        for(int i = 0 ; i<n ; i++){
            int x = (i+1)%n ;
            ans = Math.max(ans,Math.abs(nums[i]-nums[x])) ;
        }
        return ans ;
    }
}