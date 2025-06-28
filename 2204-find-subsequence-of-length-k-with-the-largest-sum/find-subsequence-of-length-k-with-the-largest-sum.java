class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if(nums.length==k)return nums ;
        int n = nums.length ;
        int[][] arr = new int[n][2];
        for(int i = 0 ; i<nums.length ; i++){
            arr[i][0] = nums[i] ;
            arr[i][1] = i ;
        }
        Arrays.sort(arr, (a,b) -> (b[0]-a[0])) ;
        Arrays.sort(arr, 0, k, Comparator.comparingInt(a -> a[1])); 
        int[] ans = new int[k] ;
        for(int i = 0 ; i<k ; i++){
            ans[i] = arr[i][0] ;
        }
        return ans ;
    }
}