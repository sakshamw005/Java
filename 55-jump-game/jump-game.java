class Solution {
    public boolean canJump(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > l) return false;
            l = Math.max(l, i + nums[i]);
        }
        return true;
    }
}