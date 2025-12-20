class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();

        for (int x : nums)
            count.put(x, count.getOrDefault(x, 0) + 1);

        for (int x : nums) {
            if (count.get(x) == 0) continue;

            if (need.getOrDefault(x, 0) > 0) {
                need.put(x, need.get(x) - 1);
                need.put(x + 1, need.getOrDefault(x + 1, 0) + 1);
            } else {
                if (count.getOrDefault(x + 1, 0) == 0 ||
                    count.getOrDefault(x + 2, 0) == 0)
                    return false;

                count.put(x + 1, count.get(x + 1) - 1);
                count.put(x + 2, count.get(x + 2) - 1);
                need.put(x + 3, need.getOrDefault(x + 3, 0) + 1);
            }

            count.put(x, count.get(x) - 1);
        }
        return true;
    }
}
