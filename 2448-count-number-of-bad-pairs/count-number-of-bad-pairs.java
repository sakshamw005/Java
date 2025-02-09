class Solution {
    public long countBadPairs(int[] nums) {
        long ans = 0 ;
        long pairs = ((long)(nums.length) * (nums.length-1))/2 ;
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            int diff = nums[i]-i ;
            ans = ans + m.getOrDefault(diff,0) ;
            m.put(diff, m.getOrDefault(diff,0) + 1) ;
        }
        return pairs-ans ;
    }
}