class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums) ;
        int min = 0 ;
        int num = 0 ;
        for(int i : nums){
            num = Math.max(i,num) ;
            min = min + num - i ;
            num++ ;
        }
        return min ;
    }
}