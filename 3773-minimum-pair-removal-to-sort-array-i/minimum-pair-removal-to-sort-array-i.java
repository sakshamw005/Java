class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for (int x : nums) ll.add(x);

        int ops = 0;

        while (!isSorted(ll)) {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < ll.size() - 1; i++) {
                int sum = ll.get(i) + ll.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            ll.remove(idx + 1);
            ll.remove(idx);
            ll.add(idx, minSum);

            ops++;
        }

        return ops;
    }

    private boolean isSorted(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) return false;
        }
        return true;
    }
}