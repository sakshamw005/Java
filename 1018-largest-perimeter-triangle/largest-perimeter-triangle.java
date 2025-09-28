class Solution {
    public int largestPerimeter(int[] nums) {
        int ans = 0 ;
        Arrays.sort(nums) ;
        for(int i = nums.length-1 ; i>=2 ; i--){
            if(check(nums[i],nums[i-1],nums[i-2])){
                ans = Math.max(ans,(nums[i]+nums[i-1]+nums[i-2])) ;
            }
        }
        return ans ;
    }
    public boolean check (int a , int b , int c){
        return (a+b>c) && (b+c>a) && (a+c>b) ;
    }
}