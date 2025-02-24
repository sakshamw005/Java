class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int left = 0 , right = arr.length - 1 , curr = 0;
        Arrays.sort(arr) ;
        int median = arr[(arr.length-1)/2] ;
        int[] ans = new int[k] ;
        while(curr<k){
            if(median - arr[left] > arr[right] - median){
                ans[curr] = arr[left] ;
                curr++ ;
                left ++ ;
            }
            else{
                ans[curr] = arr[right] ;
                curr ++ ;
                right -- ;
            }
        }
        return ans ;
    }
}