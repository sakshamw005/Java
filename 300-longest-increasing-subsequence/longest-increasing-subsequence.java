class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums) ;
    }
    public int LIS (int[] nums){
        int[] arr = new int[nums.length] ;
        arr[0] = nums[0] ;
        int l = 1 ;
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i]>arr[l-1]){
                arr[l] = nums[i] ;
                l++ ;
            }
            else{
                int idx = BinarySearch(0,l,nums[i],arr) ;
                arr[idx] = nums[i] ;
            }
        }
        return l ;
    }
    public static int BinarySearch(int i , int j , int ele , int[] arr){
        int idx = 0 ;
        while(i<j){
            int mid = i+(j-i)/2 ;
            if(arr[mid]>=ele){
                idx = mid ;
                j = mid ;
            }
            else{
                i = mid + 1 ;
            }
        }
        return idx;
    }
}