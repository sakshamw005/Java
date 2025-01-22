class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums) ;
        int ans = 0 ;
        int left = 0 , right = nums.length-1 ;
        while(left<right){
            int sum = nums[left]+nums[right] ;
            if(sum>k){
                right-- ;
            }
            else if(sum==k){
                ans++ ;
                left++ ;
                right-- ;
            }
            else{
                left++ ;
            }
        }
        return ans ;
    }
}