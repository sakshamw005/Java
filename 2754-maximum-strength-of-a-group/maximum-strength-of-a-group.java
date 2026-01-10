class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length==1)return nums[0];
        int c = 0 , mi = Integer.MAX_VALUE ;
        for(int i : nums){
            if(i<0){
                c++ ;
                mi = Math.min(mi,Math.abs(i)) ;
            }
        }
        long ans = 1 , cz = 0 ;
        for(int i : nums){
            if(i==0){
                cz++ ;
                continue ;
            } ;
            ans*=i ;
        }
        if(cz == nums.length) return 0;
        if(c == 1 && nums.length - cz == 1) return 0;
        if(c%2==0){
            return ans ;
        }
        else{
            return ans/-mi  ;
        }
    }
}