class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size() ;
        for (int a = 0; a + 2 * k <= n; a++) {
            if (inc(nums, a, k) && inc(nums, a + k, k)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean inc(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
