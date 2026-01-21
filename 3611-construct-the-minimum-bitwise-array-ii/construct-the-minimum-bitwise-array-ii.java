class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        Arrays.fill(ans, -1);

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if ((n & 1) == 1) {
                String bin = Integer.toBinaryString(n);
                StringBuilder sb = new StringBuilder(bin);
                int j = sb.length() - 1;
                while (j >= 0 && sb.charAt(j) == '1') {
                    j--;
                }
                sb.setCharAt(j + 1, '0');
                ans[i] = Integer.parseInt(sb.toString(), 2);
            }
        }
        return ans;
    }
}
//11111
//01111