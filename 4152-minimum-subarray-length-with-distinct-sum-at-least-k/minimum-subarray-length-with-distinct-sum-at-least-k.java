class Solution {
    public int minLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE ;
        Map<Integer,Integer> map = new HashMap<>() ;
        int l = 0 , r = 0 , sum = 0 ;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1) ;
            if(map.get(nums[r])==1){
                sum+=nums[r] ;
            }
            while(sum>=k){
                ans = Math.min(ans,r-l+1) ;
                map.put(nums[l],map.get(nums[l])-1) ;
                if(map.get(nums[l])==0){
                    sum-=nums[l] ;
                    map.remove(nums[l]) ;
                }
                l++ ;
            }
            r++ ;
        }
        return ans==Integer.MAX_VALUE ? -1 : ans ;
    }
}