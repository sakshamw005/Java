class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums) ;
        int ans = 0 ;
        int curr = 0 ;
        while(curr<nums.length){
            int hi = nums[curr] ;
            curr++ ;
            while(curr<nums.length && nums[curr]-hi<=k)curr++ ;
            ans++ ;
        }
        return ans ;
    }
}