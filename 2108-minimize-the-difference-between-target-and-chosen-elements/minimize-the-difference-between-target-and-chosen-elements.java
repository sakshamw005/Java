class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < mat.length; i++) {
            Set<Integer> next = new HashSet<>();
            for (int sum : set) {
                for (int val : mat[i]) {
                    next.add(sum + val);
                }
            }
            set = next;
        }

        int ans = Integer.MAX_VALUE;
        for (int sum : set) {
            ans = Math.min(ans, Math.abs(sum - target));
        }
        return ans;
    }
}