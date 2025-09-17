class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums) ;
    }
    private static int LIS(int[] arr) {
        int[] dp = new int[arr.length];
        int len = 1;
        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > dp[len-1]){
                dp[len] = arr[i];
                len++;
            }
            else{
                int idx = BinarySearch(dp,0,len-1,arr[i]) ;
                dp[idx] = arr[i];
            }
        }
        return len ;
    }
    public static int BinarySearch(int[] dp, int low, int high, int target){
        int idx = 0 ;
        while (low <= high){
            int mid = (low + high)/2 ;
            if(dp[mid]>=target){
                idx = mid;
                high = mid-1 ;
            }
            else{
                low = mid+1;
            }
        }
        return idx;
    }
}