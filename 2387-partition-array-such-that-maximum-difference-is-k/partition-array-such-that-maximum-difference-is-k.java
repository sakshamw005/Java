class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1, start = nums[0];
        for (int num : nums) {
            if (num - start > k) {
                count++;
                start = num;
            }
        }
        return count;
    }
}
