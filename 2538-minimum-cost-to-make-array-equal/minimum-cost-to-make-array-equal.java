class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = Long.MAX_VALUE ;
        int mi = Integer.MAX_VALUE , ma = Integer.MIN_VALUE ;
        for(int i : nums){
            mi = Math.min(mi,i) ;
            ma = Math.max(ma,i) ;
        }
        while(mi<ma){
            int mid = mi + (ma-mi)/2 ;
            long c1 = find(mid,cost,nums) ;
            long c2 = find(mid+1,cost,nums) ;
            ans = Math.min(c1,c2) ;
            if(c1<c2){
                ma = mid ;
            }
            else{
                mi = mid + 1 ;
            }
        }
        return find(mi, cost, nums);
    }
    public long find(int i , int[] cost , int[] nums){
        long ans = 0 ;
        for(int x = 0 ; x<nums.length ; x++){
            ans+=(long)Math.abs(nums[x]-i)*cost[x] ;
        }
        return ans ;
    }
}