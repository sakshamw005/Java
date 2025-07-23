class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans = 0 ,left = 0 ,curr=0;
        Set<Integer> s = new HashSet<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            while(s.contains(nums[i])){
                s.remove(nums[left]) ;
                curr-=nums[left] ;
                left++ ;
            }
            s.add(nums[i]) ;
            curr+=nums[i] ;
            ans = Math.max(curr,ans) ; 
        }
        return ans ;
    }
}