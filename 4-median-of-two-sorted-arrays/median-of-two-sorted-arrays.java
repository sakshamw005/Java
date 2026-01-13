class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        long[] arr = new long[nums1.length+nums2.length];
        int i = 0 , j = 0 , idx = 0 ;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[idx++] = nums1[i] ;
                i++ ;
            }
            else if(nums1[i]>nums2[j]){
                arr[idx++] = nums2[j] ;
                j++ ;
            }
            else{
                arr[idx++] = nums1[i] ;
                arr[idx++] = nums2[j] ;
                i++ ;
                j++ ;
            }
        }
        while(i!=nums1.length)arr[idx++] = nums1[i++] ;
        while(j!=nums2.length)arr[idx++] = nums2[j++] ;
        return arr.length%2!=0 ? arr[arr.length/2] : (arr[arr.length/2] + arr[(arr.length/2)-1])/2.0 ; 
    }
}