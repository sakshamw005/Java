class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0 , prod = 1 , si = 0 , ei = 0;
        while(ei<nums.length){
            prod*=nums[ei] ; //growing
            while(prod>=k && si<=ei){ //shrinking
                prod = prod/nums[si] ;
                si++ ;
            }
            ans += (ei - si + 1) ;
            ei++ ;
        }
        return ans ;
    }
}