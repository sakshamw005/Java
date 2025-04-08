class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0; 
        int idx = 0;
        while (!has(nums, idx)) {
            idx += 3;
            ans++;
        }
        return ans;
    }

    public boolean has(int[] arr, int start) {
        Set<Integer> m = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (!m.add(arr[i])) {
                return false;
            }
        }
        return true;
    }
}
