class Solution {
    public boolean isTrionic(int[] nums) {
        if (nums.length < 4) return false;
        boolean a = false, b = false, c = false;
        int idx = 0;
        int n = nums.length;

        while (idx + 1 < n && nums[idx] < nums[idx + 1]) {
            a = true;
            idx++;
        }
        if (!a || idx == n - 1) return false;

        int mid = idx;
        while (idx + 1 < n && nums[idx] > nums[idx + 1]) {
            b = true;
            idx++;
        }
        if (!b || idx == mid || idx == n - 1) return false;

        while (idx + 1 < n && nums[idx] < nums[idx + 1]) {
            c = true;
            idx++;
        }

        return c && idx == n - 1;
    }
}