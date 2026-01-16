class Solution {
    public int[] findOriginalArray(int[] nums) {
        if (nums.length % 2 != 0) return new int[]{};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Arrays.sort(nums);

        int[] ans = new int[nums.length / 2];
        int idx = 0;

        for (int i : nums) {
            if (!map.containsKey(i)) continue;

            if (i == 0 && map.get(i) < 2) return new int[]{};

            if (!map.containsKey(i * 2)) return new int[]{};

            map.put(i * 2, map.get(i * 2) - 1);
            if (map.get(i * 2) == 0) map.remove(i * 2);

            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) map.remove(i);

            ans[idx++] = i;
        }

        return idx == ans.length ? ans : new int[]{};
    }
}