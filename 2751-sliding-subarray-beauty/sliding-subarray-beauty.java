class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length ;
        int[] ans = new int[n-k+1] ;
        int[] freq = new int[50] ;
        for(int i = 0 ; i<k ; i++)if(nums[i]<0)freq[nums[i]+50]++ ;
        ans[0] = get(freq,x);
        for(int i = k ; i<n ; i++){
            if(nums[i]<0)freq[nums[i]+50]++ ;
            if(nums[i-k]<0)freq[nums[i-k]+50]-- ;
            ans[i-k+1] = get(freq,x) ;
        }
        return ans ;
    }
     public int get(int[] freq, int x) {
        int c = 0;
        for (int i = 0; i < freq.length; i++) {
            c += freq[i];
            if (c >= x) return i - 50;
        }
        return 0;
    }
}