class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length==1)return nums[0] ;
        return find(nums,0,0) ;
    }
    public int find(int[] nums , int i , int ans){
        if(i==nums.length){
            return ans ;
        }
        return find(nums,i+1,ans) + find(nums,i+1,ans^nums[i]) ;
    }
}