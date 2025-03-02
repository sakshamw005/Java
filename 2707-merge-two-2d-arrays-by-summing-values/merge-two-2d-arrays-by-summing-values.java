class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            m.put(nums1[i][0], m.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }
        for (int i = 0; i < nums2.length; i++) {
            m.put(nums2[i][0], m.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }
        int[][] ans = new int[m.size()][2];
        int i = 0;
        for (int key : new TreeSet<>(m.keySet())) {
            ans[i][0] = key;
            ans[i][1] = m.get(key);
            i++;
        }
        return ans;
    }
}
