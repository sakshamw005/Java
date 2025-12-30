class Solution {
    public double maxAmount(String initialCurrency ,List<List<String>> pairs1, double[] rates1 , List<List<String>> pairs2, double[] rates2) {

        Map<String, Map<String, Double>> d1 = build(pairs1, rates1);
        Map<String, Map<String, Double>> d2 = build(pairs2, rates2);

        Map<String, Double> m1 = dfs(initialCurrency, d1);
        double ans = 1.0;

        for (String cur : m1.keySet()) {
            Map<String, Double> m2 = dfs(cur, d2);
            if (m2.containsKey(initialCurrency)) {
                ans = Math.max(ans, m1.get(cur) * m2.get(initialCurrency));
            }
        }

        return ans;
    }

    public Map<String, Map<String, Double>> build(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < pairs.size(); i++) {
            String ini = pairs.get(i).get(0);
            String fin = pairs.get(i).get(1);
            map.putIfAbsent(ini, new HashMap<>());
            map.putIfAbsent(fin, new HashMap<>());
        }

        for (int i = 0; i < pairs.size(); i++) {
            String ini = pairs.get(i).get(0);
            String fin = pairs.get(i).get(1);
            map.get(ini).put(fin, rates[i]);
            map.get(fin).put(ini, 1.0 / rates[i]);
        }

        return map;
    }

    public Map<String, Double> dfs(String start, Map<String, Map<String, Double>> map) {
        Map<String, Double> res = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        res.put(start, 1.0);
        q.add(start);

        while (!q.isEmpty()) {
            String x = q.poll();
            double val = res.get(x);

            if (!map.containsKey(x)) continue;

            for (String y : map.get(x).keySet()) {
                double nval = val * map.get(x).get(y);
                if (nval > res.getOrDefault(y, 0.0)) {
                    res.put(y, nval);
                    q.add(y);
                }
            }
        }

        return res;
    }
}