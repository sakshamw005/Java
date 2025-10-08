class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            return a[0] - b[0]; 
        });
        return LIS(arr) ;
    }
    public int LIS(int[][] arr){
        int[] nums = new int[arr.length] ;
        int len = 1;
        nums[0] = arr[0][1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][1] > nums[len - 1]) {
                nums[len++] = arr[i][1];
            } else {
                int idx = BinarySearch(arr[i][1], nums, len, 0);
                nums[idx] = arr[i][1];
            }
        }
        return len;
    }
    public int BinarySearch(int ele , int[] nums , int high , int low){
        while(low<high){
            int mid = low + (high-low)/2 ;
            if(nums[mid] >= ele){
                high = mid ;
            }
            else{
                low = mid + 1 ;
            }
        }
        return low ;
    }
}