class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        TreeSet<Integer> arr = new TreeSet<>();
        Map<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                int ele = rains[i];

                if (last.containsKey(ele)) {
                    Integer l = arr.higher(last.get(ele));
                    if (l == null) {
                        return new int[] {};
                    }
                    ans[l] = ele;
                    arr.remove(l);
                }
                last.put(ele, i);
                ans[i] = -1;
            } 
            else {
                arr.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}