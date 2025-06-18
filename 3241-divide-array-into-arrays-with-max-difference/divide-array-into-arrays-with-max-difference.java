class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length ; 
        int[][] ans = new int[n/3][3] ;
        Arrays.sort(nums) ;
        int idx = 0 ;
        for(int i = 0 ; i < n ; i += 3){
            if (sahi(nums[i], nums[i+1], nums[i+2], k)) {
                ans[idx][0] = nums[i];
                ans[idx][1] = nums[i+1];
                ans[idx][2] = nums[i+2];
                idx++;
            } else {
                return new int[0][];
            }
        }
        return ans ;
    }
    public static boolean sahi(int n1 , int n2 , int n3,int k){
        if(n3 - n1 <= k)return true ;
        return false ;
    }
}