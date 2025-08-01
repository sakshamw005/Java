class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] count = new int[nums.length+1] ;
        for(int i : nums){
            count[i]++ ;
        }
        int[] ans = new int[2] ;
        for(int i = 0 ; i<count.length ; i++){
            if(count[i]>1){
                ans[0] = i ;
            }
            else if(count[i]==0){
                ans[1] = i ;
            }
        }
        return ans ;
    }
}