class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0 ; 
        for(int i : nums){
            sum+=i ;
        }
        int r = (int)(sum % p);
        if(r==0)return 0 ;

        Map<Integer,Integer> map = new HashMap<>() ;
        map.put(0,-1) ;
        int psum = 0 , ans = nums.length + 1 ;
        for(int i = 0 ; i < nums.length ; i++){
            psum = (psum+nums[i])%p ;
            psum = (psum+p)%p ;

            int n = (psum-r+p)%p ;

            if (map.containsKey(n)) {
                ans = Math.min(ans, i - map.get(n));
            }
            map.put(psum, i);
        }
        return ans < nums.length ? ans : -1 ;
    }
}