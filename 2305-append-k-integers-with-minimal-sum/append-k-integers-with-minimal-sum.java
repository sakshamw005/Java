class Solution {
    public long minimalKSum(int[] nums, int k) {
        Set<Integer> s = new TreeSet<>();
        for (int i : nums) s.add(i);
        long ans = (long) k * (k + 1) / 2;
        int nxt = k + 1;  

        for (int i : s) {
            if (i <= k) {
                ans -= i;
                ans += nxt;
                nxt++;
                k++;       
            }
        }
        return ans;
    }
}