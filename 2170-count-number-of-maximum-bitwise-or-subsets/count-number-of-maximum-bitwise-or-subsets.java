class Solution {
    int m = 0 , ans = 0 ;
    public int countMaxOrSubsets(int[] nums) {
        for(int i : nums){
            m|=i ;
        }
        print(0,0,nums) ;
        return ans ;
    }
    public void print(int index , int curr , int[] nums){
        if(index==nums.length){
            if(curr==m){
                ans++ ;
            }
            return ;
        }
        print(index+1, curr | nums[index], nums);
        print(index+1,curr,nums) ;
    }
}