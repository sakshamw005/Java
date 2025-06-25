class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();

        for (String w : words) {
            m.put(w, m.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(m.get(a), m.get(b));
            if (cmp == 0) return b.compareTo(a);
            return cmp;
        });

        for (String w : m.keySet()) {
            heap.offer(w);
            if (heap.size() > k) heap.poll();
        }

        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }

        Collections.reverse(ans);
        return ans;
    }
}
