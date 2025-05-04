class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums) ;
        int ans = Integer.MAX_VALUE/2 ;
        for(int i = 0 ; i<nums.length ; i++){
            for(int j = i+1 ; j<nums.length ; j++){
                for(int k = j +1 ; k<nums.length ; k++){
                    int temp = nums[i]+nums[j]+nums[k] ;
                    if(Math.abs(temp-target)<Math.abs(ans-target)){
                        ans = temp ;
                    }
                }
            }
        }
        return ans ;
    }
}