class Solution {
    static long MOD = 1_000_000_007 ;
    public int countNicePairs(int[] nums) {
        long ans = 0 ;
        Map<Integer,Long> map = new HashMap<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            nums[i] = nums[i] - rev(nums[i]) ;
            map.put(nums[i],map.getOrDefault(nums[i],0L)+1) ;
        }
        for(long i : map.values()){
            if(i>1){
                ans = (ans + (i*(i-1)/2)%MOD)%MOD ;
            }
        }
        return (int)ans ;
    }
    public int rev(int n){
        int ans = 0 ;
        while(n>0){
            ans = ans*10 + n%10 ;
            n/=10 ;
        }
        return ans ;
    }
}