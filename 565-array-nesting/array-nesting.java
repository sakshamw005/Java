class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] seen = new boolean[nums.length] ;
        int ans = 0  ;
        for(int i = 0 ; i<nums.length ; i++){
            if(!seen[i]){
                int c = 0 ;
                int j = i ;
                while(!seen[j]){
                    c++ ;
                    seen[j] = true ;
                    j = nums[j] ;
                }
                ans = Math.max(c,ans) ;
            }
        }
        return ans ;
    }
}