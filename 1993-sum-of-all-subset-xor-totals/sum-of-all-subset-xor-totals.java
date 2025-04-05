class Solution {
    public int subsetXORSum(int[] nums) {
        return sum(nums,0,0) ;
    }
    public int sum(int[] nums , int start , int x){
        if(start==nums.length){
            return x ;
        }
        int a = sum(nums,start+1,x^nums[start]) ;
        int b = sum(nums,start+1,x) ;
        return a+b ;
    }
}