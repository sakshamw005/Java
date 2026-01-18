class Solution {
    public int minimumOperations(int[] nums) {

        if (nums.length == 1) return 0;

        Map<Integer,Integer> odd = new HashMap<>();
        Map<Integer,Integer> eve = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                eve.put(nums[i], eve.getOrDefault(nums[i], 0) + 1);
            } else {
                odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
            }
        }
        int maxE = 0, secE = 0;
        int maxEKey = -1;

        for (int k : eve.keySet()) {
            int f = eve.get(k);
            if (f > maxE) {
                secE = maxE;
                maxE = f;
                maxEKey = k;
            } else if (f > secE) {
                secE = f;
            }
        }
        int maxO = 0, secO = 0;
        int maxOKey = -1;

        for (int k : odd.keySet()) {
            int f = odd.get(k);
            if (f > maxO) {
                secO = maxO;
                maxO = f;
                maxOKey = k;
            } else if (f > secO) {
                secO = f;
            }
        }
        if (maxEKey != maxOKey) {
            return nums.length - maxE - maxO;
        }
        return nums.length - Math.max(maxE + secO, maxO + secE);
    }
}