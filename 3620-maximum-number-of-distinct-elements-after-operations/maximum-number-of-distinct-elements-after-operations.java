class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums) ;
        int ans = 0 ;
        long prev = Long.MIN_VALUE;
        for (int num : nums) {
            long candidate = Math.max((long)num - k, prev + 1);
            if (candidate <= (long)num + k) {
                prev = candidate;
                ans++;
            }
        }
        return ans ;
    }
}