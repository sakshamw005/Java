class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE ;
        int start = 0 ;
        int curr = 0 ;
        for(int end = 0 ; end < nums.length ; end++){
            curr+=nums[end] ;
            while(curr>=target){
                ans = Math.min(ans,end-start+1) ;
                curr = curr - nums[start] ;
                start++ ;
            }
        }
        return ans==Integer.MAX_VALUE ?0 : ans ;
    }
}