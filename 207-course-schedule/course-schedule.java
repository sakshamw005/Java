class Solution {
    public boolean canFinish(int n, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < pre.length; i++) {
            map.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;

            for (int ne : map.get(curr)) {
                indegree[ne]--;
                if (indegree[ne] == 0) {
                    q.add(ne);
                }
            }
        }

        return count == n;
    }
}