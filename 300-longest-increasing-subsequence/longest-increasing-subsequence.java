class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        int l = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[l - 1]) {
                arr[l++] = nums[i];
            } else {
                int idx = bs(0, l - 1, nums[i], arr);
                arr[idx] = nums[i];
            }
        }
        return l;
    }

    public int bs(int lo, int hi, int ele, int[] arr) {
        int ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= ele) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}