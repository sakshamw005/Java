class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums) ;
        int ans = nums[0] + nums[1] + nums[2] ;
        int n = nums.length ;
        for(int i = 0 ; i<n-2 ; i++){
            int l = i+1 ;
            int r = n-1 ;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r] ;
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if(sum==target){
                    return sum ;
                }
                if(sum<target){
                    l++ ;
                }
                if(sum>target){
                    r-- ;
                }
            }
        }
        return ans ;
    }
}