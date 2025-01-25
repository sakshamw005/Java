class Solution {
    public long[] findPrefixScore(int[] nums) {
        long[] ans = new long[nums.length] ;
        int max = nums[0] ;
        for(int i = 0 ; i<nums.length ; i++){
            max = Math.max(max, nums[i]);
            if(i==0){
                ans[i] = 2*nums[i] ;
            }
            else{
                ans[i] = nums[i]+ max + ans[i-1] ;
            }
        }
        return ans ;
    }
}