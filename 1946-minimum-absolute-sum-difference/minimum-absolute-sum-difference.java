// class Solution {
//     private int MOD = 1_000_000_007 ;
//     public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
//         if(Arrays.equals(nums1,nums2))return 0 ;
//         int n = nums1.length ;
//         int[] diff = new int[n] ;
//         for(int i = 0 ; i<n ; i++)diff[i] = Math.abs(nums1[i]-nums2[i]) ;
//         int idx = -1 ;
//         long val = Long.MIN_VALUE ;
//         for(int i = 0 ; i<n ; i++){
//             if(diff[i]>val){
//                 val = diff[i] ;
//                 idx = i ;
//             }
//         }
//         int ele = nums2[idx] ;
//         int cho = 0 , dif = Integer.MAX_VALUE ;
//         for(int i = 0 ; i<n ; i++){
//             if(i==idx)continue ;
//             if(Math.abs(nums1[i]-ele)<dif){
//                 dif = Math.abs(nums1[i]-ele) ;
//                 cho = i ;
//             }
//         }
//         diff[idx] = Math.abs(nums1[cho] - nums2[idx]) ;
//         int ans = 0 ;
//         for(int i : diff)ans = (ans + i)%MOD ;
//         return ans ;
//     }
// }
class Solution {
    private int MOD = 1_000_000_007;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
        }
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int target = nums2[i];
            int pos = Arrays.binarySearch(sorted, target);
            if (pos < 0) pos = -pos - 1;
            if (pos < n)ans = Math.max(ans,diff[i] - Math.abs(sorted[pos] - target));
            if (pos > 0)ans = Math.max(ans, diff[i] - Math.abs(sorted[pos - 1] - target));
        }
        return (int)((sum - ans) % MOD);
    }
}