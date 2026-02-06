class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length ;
        int[] prev = comp(nums) ;
        int[] next = find(nums) ;
        long ans = Long.MIN_VALUE ;
        for(int i = 1 ; i<nums.length-1 ; i++){
            long val = (long)(prev[i-1] - nums[i]) * next[i+1] ;
            ans = Math.max(ans,val) ;
        }
        return ans > 0 ? ans : 0 ;
    }
    public int[] comp(int[] nums){
        int[] ans = new int[nums.length] ;
        ans[0] = nums[0] ;
        for(int i = 1 ; i<nums.length ; i++){
            ans[i] = Math.max(ans[i-1],nums[i]) ;
        }
        return ans ;
    }
    public int[] find(int[] nums){
        int[] ans = new int[nums.length] ;
        ans[nums.length-1] = nums[nums.length-1] ;
        for(int i = nums.length-2 ; i>=0 ; i--){
            ans[i] = Math.max(ans[i+1],nums[i]) ;
        }
        return ans ;
    }
}