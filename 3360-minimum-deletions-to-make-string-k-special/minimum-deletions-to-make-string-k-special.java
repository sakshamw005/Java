class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> m = new HashMap<>();
        for (char x : word.toCharArray()) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        List<Integer> freqList = new ArrayList<>(m.values());
        Collections.sort(freqList);

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < freqList.size(); i++) {
            int base = freqList.get(i);
            int deletions = 0;
            for (int freq : freqList) {
                if (freq < base) {
                    deletions += freq;
                } else if (freq > base + k) {
                    deletions += freq - (base + k);
                }
            }
            ans = Math.min(ans, deletions);
        }

        return ans;
    }
}